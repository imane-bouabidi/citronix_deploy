package com.wora.citronix.dtos.ferme;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class FermeEmbeddedDTO {
    private Long id;
    private String nom;
}

