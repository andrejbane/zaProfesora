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
@Table(name = "Odeljenje")
@NoArgsConstructor
@AllArgsConstructor
public class Odeljenje {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    public int Id;

    @Column(nullable = false)
    public String Naziv;

    @Column(nullable = false,name="GodinaUpisa")
    public Date GodinaUpisa;
}
