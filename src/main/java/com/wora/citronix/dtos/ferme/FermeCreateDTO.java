package com.wora.citronix.dtos.ferme;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class FermeCreateDTO {
    @NotBlank(message = "Le nom de la ferme est obligatoire.")
    private String nom;

    @NotBlank(message = "La localisation est obligatoire.")
    private String localisation;

    @Positive(message = "La superficie doit être positive.")
    private double superficie;

    @NotNull(message = "La date de création est obligatoire.")
    @PastOrPresent
    private LocalDate dateCreation;
}
