package com.wora.citronix.services.ServiceInerf;

import com.wora.citronix.dtos.arbre.ArbreUpdateDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteCreateDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteUpdateDTO;
import com.wora.citronix.entities.Arbre;
import com.wora.citronix.entities.DetailRecolte;

import java.util.List;

public interface DetailRecolteService {
//    DetailRecolteDTO save(DetailRecolteCreateDTO createDto);
    //    DetailRecolteDTO findById(Long id);
    DetailRecolteDTO update(DetailRecolteUpdateDTO detailRecolteUpdateDTO);
//    DetailRecolte findByRecolteIdAndArbreId(Long recolteId, Long arbreId);
//    List<DetailRecolteDTO> findAll(int page, int size);
//    List<DetailRecolteDTO> findByArbreId(Long fermeId,int page, int size);
//    void delete(Long id);
}
