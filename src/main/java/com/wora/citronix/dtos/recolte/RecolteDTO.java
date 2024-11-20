package com.wora.citronix.dtos.recolte;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteEmbeddedDTO;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class RecolteDTO {
    private Long id;
    private LocalDate dateRecolte;
    private String saison;
    private double quantiteTotale;
    private ChampEmbeddedDTO champ;
    private List<DetailRecolteEmbeddedDTO> details;
}
