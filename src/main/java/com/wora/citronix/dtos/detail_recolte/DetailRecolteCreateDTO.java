package com.wora.citronix.dtos.detail_recolte;

import com.wora.citronix.dtos.recolte.RecolteEmbeddedDTO;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DetailRecolteCreateDTO {
    @Positive(message = "La quantité doit être positive.")
    private double quantite;

    @NotNull(message = "L'arbre est obligatoire.")
    private Long arbreId;

//    @NotNull(message = "la récolte est obligatoire.")
//    private RecolteEmbeddedDTO recolte;
}

