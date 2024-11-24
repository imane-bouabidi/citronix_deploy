package com.wora.citronix.dtos.recolte;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import com.wora.citronix.entities.enums.Saison;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Data
@Getter
@Setter
public class RecolteCreateDTO {
    @NotNull(message = "La date de récolte est obligatoire.")
    @PastOrPresent
    private LocalDate dateRecolte;

    @NotBlank(message = "La saison est obligatoire.")
    private Saison saison;

    @NotNull(message = "champ est obligatoire.")
    private Long champId;
}

