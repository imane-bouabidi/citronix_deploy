package com.wora.citronix.Mappers;

import com.wora.citronix.dtos.champ.ChampDTO;
import com.wora.citronix.entities.Champ;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChampMapper {
    ChampDTO toDTO(Champ champ);
    Champ toEntity(ChampDTO champDTO);
    List<ChampDTO> toDTOList(List<Champ> champs);
}

