package com.wora.citronix.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailRecolte {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private double quantite;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Arbre arbre;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Recolte recolte;
}

