package api.artifakt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "Ucenik")
@NoArgsConstructor
@AllArgsConstructor
public class Ucenik {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    public int Id;

    @Column(nullable = false)
    public String Ime;

    @Column(nullable = false)
    public int Prezime;

    @Column(nullable = false)
    public int BrojNeopravdanihIzostanaka;

    @Column(nullable = false)
    public int BrojOpravdanihIzostanaka;

    @Column(nullable = false)
    public int IdOdeljenje;
}
