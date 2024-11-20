package com.wora.citronix.dtos.champ;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.UUID;

@Data
public class ChampUpdateDTO {
    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private UUID id;

    @Positive(message = "La superficie doit être positive.")
    private double superficie;

    @NotNull(message = "L'identifiant de la ferme est obligatoire.")
    private UUID fermeId;
}
