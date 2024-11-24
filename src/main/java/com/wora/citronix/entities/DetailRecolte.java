package com.wora.citronix.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailRecolte {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private double quantite;

    @ManyToOne
    @JoinColumn(name = "arbre_id",nullable = false)
    private Arbre arbre;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Recolte recolte;

    public DetailRecolte(@NotNull double quantite, Arbre arbre, Recolte recolte) {
        this.quantite = quantite;
        this.arbre = arbre;
        this.recolte = recolte;
    }
}

