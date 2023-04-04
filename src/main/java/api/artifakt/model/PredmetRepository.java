package api.artifakt.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PredmetRepository extends JpaRepository<Predmet, Integer> {
}
