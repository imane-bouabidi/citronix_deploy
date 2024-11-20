package com.wora.citronix.dtos.recolte;

import lombok.Data;
import java.util.UUID;

@Data
public class RecolteEmbeddedDTO {
    private UUID id;
    private double quantiteTotale;
    private String saison;
}

