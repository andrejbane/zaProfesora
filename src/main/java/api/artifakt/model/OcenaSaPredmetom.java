package api.artifakt.model;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class OcenaSaPredmetom {
    public int Id;

    public int BrojOcene;

    public LocalDateTime MomenatUpisivanja;

    public int IdMape;

    public int IdUcenika;

    public String NazivPredmeta;
}
