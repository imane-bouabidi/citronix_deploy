package com.wora.citronix.services.ServiceInerf;

import com.wora.citronix.dtos.ferme.FermeCreateDTO;
import com.wora.citronix.dtos.ferme.FermeDTO;
import com.wora.citronix.dtos.ferme.FermeSearchDTO;
import com.wora.citronix.dtos.ferme.FermeUpdateDTO;
import com.wora.citronix.services.GenericService;

import java.util.List;

public interface FermeService extends GenericService<FermeCreateDTO, FermeUpdateDTO,FermeDTO,Long> {
    FermeDTO save(FermeCreateDTO createDto);
//    FermeDTO findById(Long id);
    FermeDTO update(FermeUpdateDTO updateDto, Long id);
    List<FermeDTO> findAll(int page, int size);
    void delete(Long id);
    List<FermeDTO> rechercherFermes(FermeSearchDTO searchDTO);














}
