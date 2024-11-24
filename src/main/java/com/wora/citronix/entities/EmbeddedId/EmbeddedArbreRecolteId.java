package com.wora.citronix.entities.EmbeddedId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedArbreRecolteId {
    @Column(name = "arbre_id")
    @Positive
    private Long arbreId;

    @Column(name = "recolte_id")
    @Positive
    private Long recolteId;
}
