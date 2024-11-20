package com.wora.citronix.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
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

    private boolean productif;
}

