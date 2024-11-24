package com.wora.citronix.dtos.ferme;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Data
@Getter
@Setter
public class FermeEmbeddedDTO {
    private Long id;
    private String nom;
    private LocalDate dateCreation;
    private String Localisation;
    private double superficie;
}

