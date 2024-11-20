package com.wora.citronix.dtos.recolte;

import lombok.Data;
import java.util.UUID;


@Data
public class RecolteEmbeddedDTO {
    private Long id;
    private double quantiteTotale;
    private String saison;
}

