package com.wora.citronix.dtos.arbre;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ArbreUpdateDTO {
    @NotNull(message = "L'identifiant de l'arbre est obligatoire.")
    private Long id;

    @NotNull(message = "La date de plantation est obligatoire.")
    private LocalDate datePlantation;

    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private ChampEmbeddedDTO champEmbedded;
}

