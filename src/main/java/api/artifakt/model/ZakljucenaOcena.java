package api.artifakt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ZakljucenaOcena")
@NoArgsConstructor
@AllArgsConstructor
public class ZakljucenaOcena {
    @jakarta.persistence.Id
    @Column(updatable = false, nullable = false, unique = true)
    public int Id;

    @Column(nullable = false)
    public int BrojOcene;

    @Column(nullable = false)
    public LocalDateTime MomenatUpisivanja;

    @Column(nullable = false)
    public int IdMape;

    @Column(nullable = false)
    public int IdUcenika;
}
