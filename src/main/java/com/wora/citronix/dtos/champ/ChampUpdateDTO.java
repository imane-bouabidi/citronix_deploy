package com.wora.citronix.dtos.champ;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ChampUpdateDTO {
    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private Long id;

    @Positive(message = "La superficie doit être positive.")
    private Long superficie;

    @NotNull(message = "la ferme est obligatoire.")
    private Long fermeId;

}
