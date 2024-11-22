package com.wora.citronix.dtos.arbre;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ArbreEmbeddedDTO {
    private Long id;
    private LocalDate datePlantation;
    private Integer age;
    @NotNull
    private double productiviteAnnuelle;
}

