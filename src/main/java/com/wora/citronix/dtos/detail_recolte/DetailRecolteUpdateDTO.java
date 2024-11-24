package com.wora.citronix.dtos.detail_recolte;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class DetailRecolteUpdateDTO {

    @Positive(message = "La quantité doit être positive.")
    private double quantite;

    @NotNull(message = "la récolte est obligatoire.")
    private Long recolteId;

    @NotNull(message = "l'arbre est obligatoire.")
    private Long arbreId;
}

