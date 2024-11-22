package com.wora.citronix.Mappers;

import com.wora.citronix.dtos.ferme.*;
import com.wora.citronix.entities.Ferme;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FermeMapper {
    FermeDTO toDTO(Ferme ferme);
//    FermeEmbeddedDTO toEmbeddedDTO(Ferme ferme);
    Ferme toEntity(FermeDTO fermeDTO);

    @Mapping(target = "dateCreation", source = "dateCreation")
    Ferme toEntity(FermeCreateDTO fermeDTO);

    Ferme toEntity(FermeUpdateDTO fermeDTO);
    List<FermeDTO> toDTOList(List<Ferme> fermes);
}

