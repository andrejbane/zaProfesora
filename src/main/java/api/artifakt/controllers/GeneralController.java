package api.artifakt.controllers;

import api.artifakt.model.OcenaSaPredmetom;
import api.artifakt.model.Odeljenje;
import api.artifakt.model.Ucenik;
import api.artifakt.service.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/skola/")
public class GeneralController {
    private final GeneralService generalService;

    @RequestMapping(method = RequestMethod.OPTIONS)
    ResponseEntity<?> options() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.DELETE)
                .build();
    }
    @PostMapping("/execute-sql")
    public ResponseEntity<Object> executeSql(@RequestBody String sqlQuery) {
        return generalService.executeSql(sqlQuery);
    }
    @GetMapping("/get-odeljenja/")
    public List<Odeljenje> getAllOdeljenja(){
        return generalService.getAllOdeljenja();
    }
    @GetMapping("/get-ucenici/")
    public List<Ucenik> getAllUcenici(@RequestBody int idOdeljenja){
        return generalService.getAllUceniks(idOdeljenja);
    }
    @GetMapping("/get-ocene/")
    public List<OcenaSaPredmetom> getAllOcene(@RequestBody int idUcenika){
        return generalService.getAllOcenas(idUcenika);
    }
    @GetMapping("/get-zakljucne/")
    public List<OcenaSaPredmetom> getAllZakljucneOcene(@RequestBody int idUcenika){
        return generalService.getAllZakljucenaOcenas(idUcenika);
    }
}
