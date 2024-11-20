package com.wora.citronix.Mappers;

import com.wora.citronix.dtos.arbre.ArbreDTO;
import com.wora.citronix.entities.Arbre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArbreMapper {
    ArbreDTO toDTO(Arbre arbre);
    Arbre toEntity(ArbreDTO arbreDTO);
    List<ArbreDTO> toDTOList(List<Arbre> arbres);
}

