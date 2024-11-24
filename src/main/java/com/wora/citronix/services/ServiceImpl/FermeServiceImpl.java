package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.FermeMapper;
import com.wora.citronix.dtos.ferme.FermeCreateDTO;
import com.wora.citronix.dtos.ferme.FermeDTO;
import com.wora.citronix.dtos.ferme.FermeSearchDTO;
import com.wora.citronix.dtos.ferme.FermeUpdateDTO;
import com.wora.citronix.entities.Ferme;
import com.wora.citronix.repositories.FermeRepository;
import com.wora.citronix.services.ServiceInerf.FermeService;
import jakarta.persistence.EntityManager;
import com.wora.citronix.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FermeServiceImpl implements FermeService {
    private final FermeMapper fermeMapper;
    private final FermeRepository fermeRepo;
    private final EntityManager entityManager;

    public FermeDTO save(FermeCreateDTO createDto){
        Ferme ferme = fermeMapper.toEntity(createDto);
        return fermeMapper.toDTO(fermeRepo.save(ferme));
    }

    @Override
    public FermeDTO update(FermeUpdateDTO updateDto, Long id) {
        Ferme ferme = fermeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("ferme not found"));
        if (ferme != null) {
        ferme.setNom(updateDto.getNom());
        ferme.setSuperficie(updateDto.getSuperficie());
        ferme.setLocalisation(updateDto.getLocalisation());
        ferme.setDateCreation(updateDto.getDateCreation());
            ferme = fermeRepo.save(ferme);
        }
        return fermeMapper.toDTO(ferme);
    }

    @Override
    public List<FermeDTO> findAll(int page, int size){
        PageRequest pageable = PageRequest.of(page, size);
        return fermeRepo.findAll(pageable).stream()
                .map(fermeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){
        Ferme ferme = fermeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("ferme not found"));
        fermeRepo.delete(ferme);
    }

    @Transactional
    public List<FermeDTO> rechercherFermes(FermeSearchDTO searchDTO) {
            List<Ferme> fermes = fermeRepo.rechercherFermes(
                    searchDTO.getNom(),
                    searchDTO.getLocalisation(),
                    entityManager
            );
            return fermes.stream().map(fermeMapper::toDTO).toList();
        }
    }
