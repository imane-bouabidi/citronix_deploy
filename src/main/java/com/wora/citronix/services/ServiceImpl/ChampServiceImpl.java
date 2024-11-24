package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.ChampMapper;
import com.wora.citronix.dtos.champ.ChampCreateDTO;
import com.wora.citronix.dtos.champ.ChampDTO;
import com.wora.citronix.dtos.champ.ChampUpdateDTO;
import com.wora.citronix.entities.Champ;
import com.wora.citronix.entities.Ferme;
import com.wora.citronix.exceptions.FermeDepasse10ChampsException;
import com.wora.citronix.exceptions.Superficie50Exception;
import com.wora.citronix.exceptions.SuperficieDepasseeException;
import com.wora.citronix.exceptions.SuperficieMinimumException;
import com.wora.citronix.repositories.ChampRepository;
import com.wora.citronix.repositories.FermeRepository;
import com.wora.citronix.services.ServiceInerf.ChampService;
import com.wora.citronix.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChampServiceImpl implements ChampService {

    private final ChampMapper champMapper;
    private final ChampRepository champRepo;
    private final FermeRepository fermeRepository;

    @Override
    public ChampDTO save(ChampCreateDTO createDto) {
        Ferme ferme = fermeRepository.findById(createDto.getFermeId())
                .orElseThrow(() -> new EntityNotFoundException("Ferme non trouvée"));

        Champ champ = champMapper.toEntity(createDto);
        validateSuperficie(champ, createDto.getSuperficie(), ferme);

        champ.setFerme(ferme);
        return champMapper.toDTO(champRepo.save(champ));

    }

    @Override
    public ChampDTO update(ChampUpdateDTO updateDto) {
        Champ champ = champRepo.findById(updateDto.getId()).orElseThrow(() -> new EntityNotFoundException("champ not found"));
        if (champ != null) {
            champ.setSuperficie(updateDto.getSuperficie());
            champ = champRepo.save(champ);
        }
        return champMapper.toDTO(champ);
    }

    @Override
    public List<ChampDTO> findAll(int page, int size){
        PageRequest pageable = PageRequest.of(page, size);
        return champRepo.findAll(pageable).stream()
                .map(champMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ChampDTO> findByFermeId(Long fermeId, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return champRepo.findByFermeId(fermeId,pageable).stream()
                .map(champMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ChampDTO findById(Long id){
        Champ champ =  champRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Champ n'existe pas !"));
        return champMapper.toDTO(champ);
    }

    @Override
    public void delete(Long id){
        Champ champ = champRepo.findById(id).orElseThrow(()->new EntityNotFoundException("champ not found"));
        champRepo.delete(champ);
    }

    private void validateSuperficie(Champ champ, double nouvelleSuperficie, Ferme ferme) {
        double superficieTotaleChamps = champRepo.sumSuperficieByFerme(ferme.getId());

        double superficieRestante = champ != null ? superficieTotaleChamps - champ.getSuperficie() : superficieTotaleChamps;

        long nombreChamps = champRepo.countByFerme(ferme.getId());
        if (nombreChamps >= 10) {
            throw new FermeDepasse10ChampsException("Une ferme ne peut pas contenir plus de 10 champs");
        }

        if (nouvelleSuperficie < 1000) {
            throw new SuperficieMinimumException("La superficie d'un champ ne peut pas être inférieure à 0.1 hectare");
        }

        double limiteMaxSuperficie = ferme.getSuperficie() * 0.5;
        if (nouvelleSuperficie > limiteMaxSuperficie) {
            throw new Superficie50Exception("La superficie d'un champ ne peut pas dépasser 50% de la superficie de la ferme");
        }

        if (superficieRestante + nouvelleSuperficie > ferme.getSuperficie()) {
            throw new SuperficieDepasseeException("La somme des superficies des champs ne peut pas dépasser la superficie totale de la ferme");
        }
    }


}
