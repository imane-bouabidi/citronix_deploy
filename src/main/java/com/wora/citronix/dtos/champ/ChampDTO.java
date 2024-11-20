package com.wora.citronix.dtos.champ;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class ChampDTO {
    private UUID id;
    private double superficie;
    private FermeEmbeddedDTO ferme;
    private List<ArbreEmbeddedDTO> arbres;
    private RécolteEmbeddedDTO recolte;
}

