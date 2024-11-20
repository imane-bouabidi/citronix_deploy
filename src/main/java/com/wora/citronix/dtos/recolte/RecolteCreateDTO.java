package com.wora.citronix.dtos.recolte;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class RecolteCreateDTO {
    @NotNull(message = "La date de récolte est obligatoire.")
    private LocalDate dateRecolte;

    @NotBlank(message = "La saison est obligatoire.")
    private String saison;

    @Positive(message = "La quantité totale doit être positive.")
    private double quantiteTotale;

    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private UUID champId;
}

