package com.wora.citronix.services.ServiceInerf;

import com.wora.citronix.dtos.champ.ChampCreateDTO;
import com.wora.citronix.dtos.champ.ChampDTO;
import com.wora.citronix.dtos.champ.ChampUpdateDTO;
import com.wora.citronix.dtos.ferme.FermeCreateDTO;
import com.wora.citronix.dtos.ferme.FermeDTO;
import com.wora.citronix.dtos.ferme.FermeSearchDTO;
import com.wora.citronix.dtos.ferme.FermeUpdateDTO;

import java.util.List;

public interface ChampService {
    ChampDTO save(ChampCreateDTO createDto);
    //    FermeDTO findById(Long id);
    ChampDTO update(ChampUpdateDTO updateDto, Long id);
    List<ChampDTO> findAll(int page, int size);
    //    void delete(Long id);

}
