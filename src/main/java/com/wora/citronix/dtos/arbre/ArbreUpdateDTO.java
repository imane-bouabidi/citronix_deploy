package com.wora.citronix.dtos.arbre;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Getter
@Setter
public class ArbreUpdateDTO {
    @NotNull(message = "L'identifiant de l'arbre est obligatoire.")
    private Long id;

    @NotNull(message = "La date de plantation est obligatoire.")
    private LocalDate datePlantation;

    @Min(0)
    @Max(20)
    private Integer age;

    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private Long champId;
    @NotNull
    private double productiviteAnnuelle;

}

