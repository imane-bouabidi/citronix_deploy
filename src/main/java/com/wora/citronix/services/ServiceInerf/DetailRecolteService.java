package com.wora.citronix.services.ServiceInerf;

import com.wora.citronix.dtos.detail_recolte.DetailRecolteCreateDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteUpdateDTO;

import java.util.List;

public interface DetailRecolteService {
    DetailRecolteDTO save(DetailRecolteCreateDTO createDto);
    //    DetailRecolteDTO findById(Long id);
//    DetailRecolteDTO update(DetailRecolteUpdateDTO updateDto);
//    List<DetailRecolteDTO> findAll(int page, int size);
//    List<DetailRecolteDTO> findByArbreId(Long fermeId,int page, int size);
//    void delete(Long id);
}
