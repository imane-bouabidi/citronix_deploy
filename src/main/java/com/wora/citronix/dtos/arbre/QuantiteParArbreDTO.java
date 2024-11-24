package com.wora.citronix.dtos.arbre;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuantiteParArbreDTO {
    private Long arbreId;
    private double quantite;
}