package com.wora.citronix.dtos.ferme;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class FermeDTO {
    private Long id;
    private String nom;
    private String localisation;
    private double superficie;
    private LocalDate dateCreation;
    private List<ChampEmbeddedDTO> champs;
}

