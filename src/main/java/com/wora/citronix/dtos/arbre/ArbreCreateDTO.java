package com.wora.citronix.dtos.arbre;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Data
@Getter
@Setter
public class ArbreCreateDTO {
    @NotNull(message = "La date de plantation est obligatoire.")
    private LocalDate datePlantation;

    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private Long champId;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer age;

//    public Integer setAge(LocalDate datePlantation) {
//        this.datePlantation = datePlantation;
//        if (this.datePlantation != null) {
//            LocalDate today = LocalDate.now();
//            Integer age = Period.between(this.datePlantation, today).getYears();
//        }
//        return age;
//    }

    @NotNull
    private double productiviteAnnuelle;

}

