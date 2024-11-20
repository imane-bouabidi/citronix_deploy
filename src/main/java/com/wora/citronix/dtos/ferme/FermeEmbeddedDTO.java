package com.wora.citronix.dtos.ferme;

import lombok.Data;
import java.util.UUID;

@Data
public class FermeEmbeddedDTO {
    private UUID id;
    private String nom;
}

