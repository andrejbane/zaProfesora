package api.artifakt.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface NastavnikRepository extends JpaRepository<Nastavnik, Integer> {

}
