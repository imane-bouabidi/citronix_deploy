package com.wora.citronix.dtos.arbre;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ArbreEmbeddedDTO {
    private UUID id;
    private LocalDate datePlantation;
}

