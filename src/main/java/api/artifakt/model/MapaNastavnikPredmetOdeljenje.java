package api.artifakt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "MapaNastavnikPredmetOdeljenje")
@NoArgsConstructor
@AllArgsConstructor
public class MapaNastavnikPredmetOdeljenje {
    @jakarta.persistence.Id
    @Column(updatable = false, nullable = false, unique = true)
    public int Id;

    @Column(nullable = false)
    public int IdNastavnik;

    @Column(nullable = false)
    public int IdOdeljenje;

    @Column(nullable = false)
    public int IdPredmet;
}
