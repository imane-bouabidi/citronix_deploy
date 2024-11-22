package com.wora.citronix.services.ServiceInerf;

import com.wora.citronix.dtos.arbre.ArbreCreateDTO;
import com.wora.citronix.dtos.arbre.ArbreDTO;
import com.wora.citronix.dtos.arbre.ArbreUpdateDTO;
import com.wora.citronix.dtos.champ.ChampDTO;

import java.util.List;

public interface ArbreService {
    ArbreDTO save(ArbreCreateDTO createDto);
    //    ArbreDTO findById(Long id);
    ArbreDTO update(ArbreUpdateDTO updateDto, Long id);
    List<ArbreDTO> findAll(int page, int size);
    void delete(Long id);
    List<ArbreDTO> findByChampId(Long champId, int page, int size);


}
