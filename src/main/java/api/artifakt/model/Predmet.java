package api.artifakt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Predmet")
@NoArgsConstructor
@AllArgsConstructor
public class Predmet {
    @jakarta.persistence.Id
    @Column(updatable = false, nullable = false, unique = true)
    public int Id;

    @Column(nullable = false)
    public String Naziv;
}
