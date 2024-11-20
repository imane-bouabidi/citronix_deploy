package com.wora.citronix.dtos.recolte;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;


@Data
public class RecolteUpdateDTO {
    @NotNull(message = "L'identifiant de la récolte est obligatoire.")
    private Long id;

    @NotNull(message = "La date de récolte est obligatoire.")
    private LocalDate dateRecolte;

    @NotBlank(message = "La saison est obligatoire.")
    private String saison;

    @Positive(message = "La quantité totale doit être positive.")
    private double quantiteTotale;

    @NotNull(message = "champ est obligatoire.")
    private ChampEmbeddedDTO champ;
}

