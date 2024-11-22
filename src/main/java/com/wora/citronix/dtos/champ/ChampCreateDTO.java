package com.wora.citronix.dtos.champ;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ChampCreateDTO {
    @Positive(message = "La superficie doit être positive.")
    private Long superficie;

    @NotNull(message = "L'identifiant de la ferme est obligatoire.")
    private Long fermeId;

}

