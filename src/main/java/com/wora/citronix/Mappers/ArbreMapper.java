package com.wora.citronix.Mappers;

@Mapper(componentModel = "spring")
public interface ArbreMapper {
    ArbreDTO toDTO(Arbre arbre);
    Arbre toEntity(ArbreDTO arbreDTO);
    List<ArbreDTO> toDTOList(List<Arbre> arbres);
}

