package com.wora.citronix.dtos.recolte;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class RecolteDTO {
    private UUID id;
    private LocalDate dateRecolte;
    private String saison;
    private double quantiteTotale;
    private ChampEmbeddedDTO champ;
    private List<DétailRécolteEmbeddedDTO> details;
}
