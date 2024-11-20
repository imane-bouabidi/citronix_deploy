package com.wora.citronix.dtos.arbre;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ArbreUpdateDTO {
    @NotNull(message = "L'identifiant de l'arbre est obligatoire.")
    private UUID id;

    @NotNull(message = "La date de plantation est obligatoire.")
    private LocalDate datePlantation;

    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private UUID champId;
}

