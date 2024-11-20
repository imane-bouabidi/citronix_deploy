package com.wora.citronix.dtos.detail_recolte;

import com.wora.citronix.dtos.recolte.RecolteEmbeddedDTO;
import lombok.Data;
import java.util.UUID;

@Data
public class DetailRecolteDTO {
    private Long id;
    private double quantite;
    private String typeProduit;
    private RecolteEmbeddedDTO recolte;
}

