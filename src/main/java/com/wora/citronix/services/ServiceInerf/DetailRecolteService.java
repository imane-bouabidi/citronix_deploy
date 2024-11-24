package com.wora.citronix.services.ServiceInerf;

import com.wora.citronix.dtos.arbre.ArbreUpdateDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteCreateDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteUpdateDTO;
import com.wora.citronix.entities.Arbre;
import com.wora.citronix.entities.DetailRecolte;
import com.wora.citronix.entities.EmbeddedId.EmbeddedArbreRecolteId;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DetailRecolteService {
//    DetailRecolteDTO save(DetailRecolteCreateDTO createDto);
    //    DetailRecolteDTO findById(Long id);
    DetailRecolteDTO update(DetailRecolteUpdateDTO detailRecolteUpdateDTO);
//    List<DetailRecolteDTO> findAll(int page, int size);
DetailRecolteDTO findByRecolteIdAndArbreId(Long recolteId, Long arbreId);
//    void delete(Long id);
}
