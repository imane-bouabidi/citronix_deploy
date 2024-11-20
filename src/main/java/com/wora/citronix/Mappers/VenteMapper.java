package com.wora.citronix.Mappers;

@Mapper(componentModel = "spring")
public interface VenteMapper {
    VenteDTO toDTO(Vente vente);
    Vente toEntity(VenteDTO venteDTO);
    List<VenteDTO> toDTOList(List<Vente> ventes);
}

