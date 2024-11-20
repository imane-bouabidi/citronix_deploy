package com.wora.citronix.dtos.vente;

import lombok.Data;
import java.util.UUID;

@Data
public class VenteEmbeddedDTO {
    private UUID id;
    private LocalDate dateVente;
    private double montantTotal;
}

