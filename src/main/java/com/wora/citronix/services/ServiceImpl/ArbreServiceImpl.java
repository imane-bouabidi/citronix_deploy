package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.ArbreMapper;
import com.wora.citronix.dtos.arbre.ArbreCreateDTO;
import com.wora.citronix.dtos.arbre.ArbreDTO;
import com.wora.citronix.dtos.arbre.ArbreUpdateDTO;
import com.wora.citronix.entities.Arbre;
import com.wora.citronix.entities.Champ;
import com.wora.citronix.repositories.ArbreRepository;
import com.wora.citronix.repositories.ChampRepository;
import com.wora.citronix.services.ServiceInerf.ArbreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArbreServiceImpl implements ArbreService {
    private final ChampRepository champRepository;
    private final ArbreMapper arbreMapper;
    private final ArbreRepository arbreRepo;

    public ArbreDTO save(ArbreCreateDTO createDto) {
        Optional<Champ> champOptional = champRepository.findById(createDto.getChampId());
        if (champOptional.isEmpty()) {
            throw new EntityNotFoundException("Champ non trouvé");
        }
        Champ champ = champOptional.get();
        createDto.setAge(calculateAge(createDto.getDatePlantation()));
        Arbre arbre = arbreMapper.toEntity(createDto);
        arbre.setChamp(champ);

        Arbre savedArbre = arbreRepo.save(arbre);
        return arbreMapper.toDTO(savedArbre);

    }

    public ArbreDTO findById(Long id){
        Arbre arbre = arbreRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return arbreMapper.toDTO(arbre);
    }

    public ArbreDTO update(ArbreUpdateDTO updateDto, Long id) {
        Arbre arbre = arbreRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("arbre not found"));
        Champ champ = champRepository.findById(updateDto.getChampId()).orElseThrow(() -> new EntityNotFoundException("champ not found"));
        if (arbre != null) {
            arbre.setDatePlantation(updateDto.getDatePlantation());
            arbre.setAge(updateDto.getAge());
            arbre.setChamp(champ);
//            arbre.setProductif(updateDto.get);
            arbre = arbreRepo.save(arbre);
        }
        return arbreMapper.toDTO(arbre);
    }

    public List<ArbreDTO> findAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return arbreRepo.findAll(pageable).stream()
                .map(arbreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArbreDTO> findByChampId(Long champId, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return arbreRepo.findByChampId(champId,pageable).stream()
                .map(arbreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){
        arbreRepo.deleteById(id);
    }

    private Integer calculateAge(LocalDate datePlantation){
        return (int) ChronoUnit.YEARS.between(datePlantation, LocalDate.now());
    }
}