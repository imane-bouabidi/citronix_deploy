package com.wora.citronix.Mappers;

@Mapper(componentModel = "spring")
public interface RecolteMapper {
    RécolteDTO toDTO(Récolte recolte);
    Récolte toEntity(RécolteDTO recolteDTO);
    List<RécolteDTO> toDTOList(List<Récolte> recoltes);
}

