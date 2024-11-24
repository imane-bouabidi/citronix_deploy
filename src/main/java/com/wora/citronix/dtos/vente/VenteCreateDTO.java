package com.wora.citronix.dtos.vente;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class VenteCreateDTO {
    @NotNull(message = "La date de vente est obligatoire.")
    private LocalDate dateVente;

    @Column(nullable = false)
    private double prixUnitaire;

    @Column(nullable = false)
    private String client;

    @NotNull(message = "la récolte est obligatoire.")
    private Long recolteId;
}

