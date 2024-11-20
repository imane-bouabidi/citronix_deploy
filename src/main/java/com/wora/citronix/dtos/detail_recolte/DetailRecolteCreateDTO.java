package com.wora.citronix.dtos.detail_recolte;

import com.wora.citronix.dtos.recolte.RecolteEmbeddedDTO;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.UUID;

@Data
public class DetailRecolteCreateDTO {
    @Positive(message = "La quantité doit être positive.")
    private double quantite;

    @NotBlank(message = "Le type de produit est obligatoire.")
    private String typeProduit;

    @NotNull(message = "la récolte est obligatoire.")
    private RecolteEmbeddedDTO recolte;
}

