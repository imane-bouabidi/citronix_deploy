package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.ChampMapper;
import com.wora.citronix.Mappers.FermeMapper;
import com.wora.citronix.dtos.champ.ChampCreateDTO;
import com.wora.citronix.dtos.champ.ChampDTO;
import com.wora.citronix.dtos.champ.ChampUpdateDTO;
import com.wora.citronix.entities.Champ;
import com.wora.citronix.entities.Ferme;
import com.wora.citronix.exceptions.SuperficieDepasseeException;
import com.wora.citronix.repositories.ChampRepository;
import com.wora.citronix.repositories.FermeRepository;
import com.wora.citronix.services.ServiceInerf.ChampService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChampServiceImpl implements ChampService {

    private final ChampMapper champMapper;
    private final ChampRepository champRepo;
    private final FermeRepository fermeRepository;

    @Override
    public ChampDTO save(ChampCreateDTO createDto) {
        Optional<Ferme> fermeOptional = fermeRepository.findById(createDto.getFermeId());
        if (fermeOptional.isEmpty()) {
            throw new EntityNotFoundException("Ferme non trouvee");
        }
        Ferme ferme = fermeOptional.get();
        //verifier que la superficie des champs est < la superficie totale
        double superficieTotaleChamps = champRepo.sumSuperficieByFerme(createDto.getFermeId());

        if (superficieTotaleChamps + createDto.getSuperficie() > ferme.getSuperficie()) {
            throw new SuperficieDepasseeException("La somme des superficies des champs ne peut pas dépasser la superficie totale de la ferme");
        }
        Champ champ = champMapper.toEntity(createDto);
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
}
