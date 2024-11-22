package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.ChampMapper;
import com.wora.citronix.Mappers.FermeMapper;
import com.wora.citronix.dtos.champ.ChampCreateDTO;
import com.wora.citronix.dtos.champ.ChampDTO;
import com.wora.citronix.dtos.champ.ChampUpdateDTO;
import com.wora.citronix.entities.Champ;
import com.wora.citronix.entities.Ferme;
import com.wora.citronix.repositories.ChampRepository;
import com.wora.citronix.repositories.FermeRepository;
import com.wora.citronix.services.ServiceInerf.ChampService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChampServiceImpl implements ChampService {

    private final ChampMapper champMapper;
    private final ChampRepository champRepo;
    private final FermeRepository fermeRepository;


    public ChampDTO save(ChampCreateDTO createDto){
        Champ champ = champMapper.toEntity(createDto);
        return champMapper.toDTO(champRepo.save(champ));
    }

    @Override
    public ChampDTO update(ChampUpdateDTO updateDto, Long id) {
        Champ champ = champRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("champ not found"));
        Ferme ferme = fermeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ferme not found"));
        if (champ != null && ferme != null) {
            champ.setSuperficie(updateDto.getSuperficie());
            champ.setFerme(ferme);
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
}
