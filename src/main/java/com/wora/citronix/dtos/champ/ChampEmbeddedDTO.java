package com.wora.citronix.dtos.champ;

import lombok.Data;
import java.util.UUID;

@Data
public class ChampEmbeddedDTO {
    private UUID id;
    private double superficie;
}

