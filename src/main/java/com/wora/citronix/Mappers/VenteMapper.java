package com.wora.citronix.Mappers;

import com.wora.citronix.dtos.vente.VenteDTO;
import com.wora.citronix.entities.Vente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VenteMapper {
    VenteDTO toDTO(Vente vente);
    Vente toEntity(VenteDTO venteDTO);
    List<VenteDTO> toDTOList(List<Vente> ventes);
}

