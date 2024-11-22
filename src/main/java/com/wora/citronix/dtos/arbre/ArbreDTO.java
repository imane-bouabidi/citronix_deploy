package com.wora.citronix.dtos.arbre;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ArbreDTO {
    private Long id;
    private LocalDate datePlantation;
    private ChampEmbeddedDTO champ;
    private Integer age;
    @NotNull
    private double productiviteAnnuelle;
}
