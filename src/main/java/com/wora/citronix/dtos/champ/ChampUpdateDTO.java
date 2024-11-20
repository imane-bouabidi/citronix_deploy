package com.wora.citronix.dtos.champ;

import com.wora.citronix.dtos.ferme.FermeEmbeddedDTO;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.UUID;

@Data
public class ChampUpdateDTO {
    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private Long id;

    @Positive(message = "La superficie doit être positive.")
    private Long superficie;

    @NotNull(message = "la ferme est obligatoire.")
    private FermeEmbeddedDTO fermeEmbedded;

}
