package com.wora.citronix.services.ServiceInerf;

import com.wora.citronix.dtos.champ.ChampCreateDTO;
import com.wora.citronix.dtos.champ.ChampDTO;
import com.wora.citronix.dtos.champ.ChampUpdateDTO;

import java.util.List;

public interface ChampService {
    ChampDTO save(ChampCreateDTO createDto);
    //    FermeDTO findById(Long id);
    ChampDTO update(ChampUpdateDTO updateDto, Long id);
    List<ChampDTO> findAll(int page, int size);
    //    void delete(Long id);

}
