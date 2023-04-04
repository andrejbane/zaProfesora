package api.artifakt.service;

import api.artifakt.model.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class GeneralService {
    @Autowired
    private final MapaNastavnikPredmetOdeljenjeRepository mapaNastavnikPredmetOdeljenjeRepository;

    @Autowired
    private final NastavnikRepository nastavnikRepository;

    @Autowired
    private final OcenaRepository ocenaRepository;

    @Autowired
    private final ZakljucenaOcenaRepository zakljucenaOcenaRepository;

    @Autowired
    private final UcenikRepository ucenikRepository;

    @Autowired
    private final OdeljenjeRepository odeljenjeRepository;

    @Autowired
    private final PredmetRepository predmetRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Odeljenje> getAllOdeljenja(){
        return odeljenjeRepository.findAll();
    }
    public List<Ucenik> getAllUceniks(int idOdeljenje){
        List<Ucenik> uce = ucenikRepository.findAll();
        int vel = uce.size();
        for (int i =0;i<vel;i++){
            if(idOdeljenje!=uce.get(i).getIdOdeljenje()){
                uce.remove(i);
                i--;
                vel--;
            }
        }
        return uce;
    }
    public List<OcenaSaPredmetom> getAllOcenas(int idUcenik){
        List<Ocena> oce = ocenaRepository.findAll();
        List<MapaNastavnikPredmetOdeljenje> mapaNastavnikPredmetOdeljenjes = mapaNastavnikPredmetOdeljenjeRepository.findAll();
        List<OcenaSaPredmetom> oces = null;
        int vel = oce.size();
        for (int i =0;i<vel;i++){
            if(idUcenik!=oce.get(i).getIdUcenika()){
                oces.add(new OcenaSaPredmetom(oce.get(i).getId(),oce.get(i).getBrojOcene(),oce.get(i).getMomenatUpisivanja(),oce.get(i).getIdMape(),oce.get(i).getIdUcenika(),kojPredmet(mapaNastavnikPredmetOdeljenjes,oce.get(i).getIdMape())));
            }
        }
        return oces;
    }
    public List<OcenaSaPredmetom> getAllZakljucenaOcenas(int idUcenik){
        List<ZakljucenaOcena> oce = zakljucenaOcenaRepository.findAll();
        List<MapaNastavnikPredmetOdeljenje> mapaNastavnikPredmetOdeljenjes = mapaNastavnikPredmetOdeljenjeRepository.findAll();
        List<OcenaSaPredmetom> oces = null;
        int vel = oce.size();
        for (int i =0;i<vel;i++){
            if(idUcenik!=oce.get(i).getIdUcenika()){
                oces.add(new OcenaSaPredmetom(oce.get(i).getId(),oce.get(i).getBrojOcene(),oce.get(i).getMomenatUpisivanja(),oce.get(i).getIdMape(),oce.get(i).getIdUcenika(),kojPredmet(mapaNastavnikPredmetOdeljenjes,oce.get(i).getIdMape())));
            }
        }
        return oces;
    }
    public String kojPredmet(List<MapaNastavnikPredmetOdeljenje> mapaNastavnikPredmetOdeljenjes, int IdOdeljenja){
        List<Predmet> P = predmetRepository.findAll();
        for (int i=0;i<mapaNastavnikPredmetOdeljenjes.size();i++)
            if(mapaNastavnikPredmetOdeljenjes.get(i).getId()==IdOdeljenja)
                for (int j=0;j<P.size();j++){
                    if(mapaNastavnikPredmetOdeljenjes.get(i).getIdPredmet()==P.get(j).getId()){
                        return P.get(j).getNaziv();
                    }

                }
        return null;
    }

    @Transactional
    public ResponseEntity<Object> executeSql(String sqlQuery) {
        try {
            Query query = entityManager.createNativeQuery(sqlQuery);
            boolean isUpdateOrDelete = query.executeUpdate() > 0;
            if (isUpdateOrDelete) {
                return ResponseEntity.ok("Query executed successfully with " + query.executeUpdate() + " rows affected.");
            } else {
                List<Object[]> resultSet = query.getResultList();
                return ResponseEntity.ok(resultSet);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error executing query: " + e.getMessage());
        }
    }



}
