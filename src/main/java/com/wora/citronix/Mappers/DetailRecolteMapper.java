package com.wora.citronix.Mappers;

import com.wora.citronix.dtos.detail_recolte.DetailRecolteCreateDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteUpdateDTO;
import com.wora.citronix.entities.DetailRecolte;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetailRecolteMapper {
    DetailRecolteDTO toDTO(DetailRecolte detailRecolte);
    DetailRecolte toEntity(DetailRecolteCreateDTO detailRecolteDTO);
    DetailRecolte toEntity(DetailRecolteUpdateDTO detailRecolteDTO);
    List<DetailRecolteDTO> toDTOList(List<DetailRecolte> details);
}

