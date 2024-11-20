package com.wora.citronix.Mappers;

@Mapper(componentModel = "spring")
public interface DetailRecolteMapper {
    DetailRecolteDTO toDTO(DetailRecolte detailRecolte);
    DetailRecolte toEntity(DetailRecolteDTO detailRecolteDTO);
    List<DetailRecolteDTO> toDTOList(List<DetailRecolte> details);
}

