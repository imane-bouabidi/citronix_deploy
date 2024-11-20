package com.wora.citronix.dtos.ferme;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
public class FermeDTO {
    private Long id;
    private String nom;
    private String localisation;
    private double superficie;
    private LocalDate dateCreation;
    private List<ChampEmbeddedDTO> champs;
}

