package com.wora.citronix.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Arbre {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private LocalDate datePlantation;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "champ_id", nullable = false)
    private Champ champ;

    @OneToMany(mappedBy = "arbre", cascade = CascadeType.ALL)
    private List<DetailRecolte> detailRecoltes;

    @NotNull
    private double productiviteAnnuelle = 0.0;


    public void calculerProductivite() {
        if (age < 3) {
            this.productiviteAnnuelle = 2.5;
        } else if (age <= 10) {
            this.productiviteAnnuelle = 12.0;
        } else {
            this.productiviteAnnuelle = 20.0;
        }
    }

}

