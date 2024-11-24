package com.wora.citronix.services.ServiceInerf;

import com.wora.citronix.dtos.recolte.RecolteCreateDTO;
import com.wora.citronix.dtos.recolte.RecolteDTO;
import com.wora.citronix.dtos.recolte.RecolteUpdateDTO;
import com.wora.citronix.services.GenericService;

import java.util.List;

public interface RecolteService extends GenericService<RecolteCreateDTO, RecolteUpdateDTO, RecolteDTO,Long> {
    RecolteDTO save(RecolteCreateDTO createDto);
//    DTO findById(ID id);
//    RecolteDTO update(RecolteUpdateDTO updateDto, Long id);
//    List<RecolteDTO> findAll(int page, int size);
//    void delete(ID id);
}
