package com.wora.citronix.Mappers;

import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FermeMapper {
    FermeDTO toDTO(Ferme ferme);
    Ferme toEntity(FermeDTO fermeDTO);
    List<FermeDTO> toDTOList(List<Ferme> fermes);
}

