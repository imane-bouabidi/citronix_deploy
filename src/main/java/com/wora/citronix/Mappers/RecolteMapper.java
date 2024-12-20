package com.wora.citronix.Mappers;

import com.wora.citronix.dtos.recolte.RecolteCreateDTO;
import com.wora.citronix.dtos.recolte.RecolteDTO;
import com.wora.citronix.dtos.recolte.RecolteUpdateDTO;
import com.wora.citronix.entities.Recolte;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RecolteMapper {
    RecolteDTO toDTO(Recolte recolte);
    Recolte toEntity(RecolteDTO recolteDTO);
    Recolte toEntity(RecolteCreateDTO recolteDTO);
    Recolte toEntity(RecolteUpdateDTO recolteDTO);
    List<RecolteDTO> toDTOList(List<Recolte> recoltes);
}

