package com.wora.citronix.dtos.ferme;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class FermeUpdateDTO {
    @NotNull(message = "L'identifiant de la ferme est obligatoire.")
    private Long id;

    @NotBlank(message = "Le nom de la ferme est obligatoire.")
    private String nom;

    @NotBlank(message = "La localisation est obligatoire.")
    private String localisation;

    @Positive(message = "La superficie doit être positive.")
    private double superficie;

    @NotNull(message = "La date de création est obligatoire.")
    private LocalDate dateCreation;
}

