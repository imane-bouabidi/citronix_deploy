package com.wora.citronix.dtos.vente;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class VenteDTO {
    private Long id;
    private LocalDate dateVente;
    private double prixUnitaire;
    private String client;
    private Long recolteId;
}

