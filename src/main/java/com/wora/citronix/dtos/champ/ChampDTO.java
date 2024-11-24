package com.wora.citronix.dtos.champ;

import com.wora.citronix.dtos.arbre.ArbreEmbeddedDTO;
import com.wora.citronix.dtos.ferme.FermeEmbeddedDTO;
import com.wora.citronix.dtos.recolte.RecolteEmbeddedDTO;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class ChampDTO {
    private Long id;
    private Long superficie;
    private FermeEmbeddedDTO ferme;
    private List<ArbreEmbeddedDTO> arbres;
    private List<RecolteEmbeddedDTO> recolte;
}

