package com.wora.citronix.services.ServiceInerf;

import com.wora.citronix.dtos.vente.VenteCreateDTO;
import com.wora.citronix.dtos.vente.VenteDTO;
import com.wora.citronix.dtos.vente.VenteUpdateDTO;
import com.wora.citronix.services.GenericService;

public interface VenteService extends GenericService<VenteCreateDTO, VenteUpdateDTO, VenteDTO,Long> {
    VenteDTO save(VenteCreateDTO createDto);
    VenteDTO getVenteRevenu(Long venteId);


}
