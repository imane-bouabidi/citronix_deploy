package com.wora.citronix.Mappers;

@Mapper(componentModel = "spring")
public interface ChampMapper {
    ChampDTO toDTO(Champ champ);
    Champ toEntity(ChampDTO champDTO);
    List<ChampDTO> toDTOList(List<Champ> champs);
}

