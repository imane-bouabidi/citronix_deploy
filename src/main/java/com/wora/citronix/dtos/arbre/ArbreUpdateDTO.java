package com.wora.citronix.dtos.arbre;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class ArbreUpdateDTO {

    @NotNull(message = "La date de plantation est obligatoire.")
    private LocalDate datePlantation;

    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private Long champId;

}

