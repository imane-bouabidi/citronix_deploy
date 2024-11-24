package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.RecolteMapper;
import com.wora.citronix.Mappers.VenteMapper;
import com.wora.citronix.dtos.vente.VenteCreateDTO;
import com.wora.citronix.dtos.vente.VenteDTO;
import com.wora.citronix.entities.Recolte;
import com.wora.citronix.entities.Vente;
import com.wora.citronix.repositories.VenteRepository;
import com.wora.citronix.services.ServiceInerf.RecolteService;
import com.wora.citronix.services.ServiceInerf.VenteService;
import com.wora.citronix.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VenteServiceImpl implements VenteService {

    private final VenteMapper venteMapper;
    private final RecolteService recolteService;
    private final RecolteMapper recolteMapper;
    private final VenteRepository venteRepository;

    public VenteDTO save(VenteCreateDTO createDto){
        Recolte recolte = recolteMapper.toEntity(recolteService.findById(createDto.getRecolteId()));
        Vente vente = venteMapper.toEntity(createDto);
        vente.setDateVente(createDto.getDateVente());
        vente.setPrixUnitaire(createDto.getPrixUnitaire());
        vente.setClient(createDto.getClient());
        vente.setRecolte(recolte);

        return  venteMapper.toDTO(venteRepository.save(vente));

    }
    //afficher revenu d'une vente
    @Override
    public VenteDTO getVenteRevenu(Long venteId){
        Vente vente = venteRepository.findById(venteId).orElseThrow(()->new EntityNotFoundException("vente note found !"));
        VenteDTO venteDTO =  venteMapper.toDTO(vente);
        venteDTO.setRevenu(vente.getRevenu());
        return venteDTO;
    }

}
