package com.wora.citronix.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vente {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private LocalDate dateVente;

    @Column(nullable = false)
    private double prixUnitaire;

    @Column(nullable = false)
    private double quantite;

    @Column(nullable = false)
    private String client;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Recolte recolte;

    public double getRevenu() {
        return quantite * prixUnitaire;
    }
}

