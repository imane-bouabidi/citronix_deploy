package com.wora.citronix.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vente {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDate dateVente;

    @Column(nullable = false)
    private double prixUnitaire;

    @Column(nullable = false)
    private String client;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Recolte recolte;

    public double getRevenu() {
        return recolte.getQuantiteTotale() * prixUnitaire;
    }

}

