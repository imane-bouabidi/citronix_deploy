package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.ArbreMapper;
import com.wora.citronix.dtos.arbre.ArbreCreateDTO;
import com.wora.citronix.dtos.arbre.ArbreDTO;
import com.wora.citronix.dtos.arbre.ArbreUpdateDTO;
import com.wora.citronix.entities.Arbre;
import com.wora.citronix.entities.Champ;
import com.wora.citronix.exceptions.DatePlantationException;
import com.wora.citronix.exceptions.DensiteArbresException;
import com.wora.citronix.exceptions.EntityNotFoundException;
import com.wora.citronix.exceptions.PlusDe20Exception;
import com.wora.citronix.repositories.ArbreRepository;
import com.wora.citronix.repositories.ChampRepository;
import com.wora.citronix.services.ServiceInerf.ArbreService;
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

        //verifier si champ existe
        if (champOptional.isEmpty()) {
            throw new EntityNotFoundException("Champ non trouvé");
        }

        //handler date de plantation erreur
        if (!isDatePlantationValide(createDto.getDatePlantation())) {
            throw new DatePlantationException("La plantation d'arbres est limitée aux mois de mars, avril et mai et ne peut pas etre au future.");
        }

        Champ champ = champOptional.get();
        long nombreArbres = arbreRepo.countByChamp(champ);

        // calculer l'age a l'aide de date de plantation
        int age = calculateAge(createDto.getDatePlantation());

        //empecher la plantation d'une arbre plus de 20 ans
        if (age > 20) {
            throw new PlusDe20Exception("Les arbres plus de 20 ans ne peuvent pas etre plantés !");
        }
        createDto.setAge(age);

        //calcul du productivité annuelle
        createDto.setProductiviteAnnuelle(calculerProductiviteAnnuelle(age));

        //verifier que le champ ne contient pas plus de 100 arbre par hectare
        if ((nombreArbres + 1) > champ.getSuperficie() * 100) {
            throw new DensiteArbresException("La densité des arbres dans ce champ ne peut pas dépasser 100 arbres par hectare.");
        }

        Arbre arbre = arbreMapper.toEntity(createDto);
        arbre.setChamp(champ);

        Arbre savedArbre = arbreRepo.save(arbre);
        return arbreMapper.toDTO(savedArbre);

    }

    public ArbreDTO findById(Long id){
        Arbre arbre = arbreRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Arbre n'existe pas !"));
        return arbreMapper.toDTO(arbre);
    }

    public ArbreDTO update(ArbreUpdateDTO updateDto, Long id) {
        Arbre arbre = arbreRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("arbre not found"));
        Champ champ = champRepository.findById(updateDto.getChampId()).orElseThrow(() -> new EntityNotFoundException("champ not found"));
        if (arbre != null) {
            if (!isDatePlantationValide(updateDto.getDatePlantation())) {
                throw new DatePlantationException("La plantation d'arbres est limitée aux mois de mars, avril et mai et ne peut pas etre au future.");
            }
            arbre.setDatePlantation(updateDto.getDatePlantation());
            int age = calculateAge(updateDto.getDatePlantation());

            if (age > 20) {
                throw new PlusDe20Exception("Les arbres plus de 20 ans ne peuvent pas etre plantés !");
            }
            arbre.setAge(age);
            arbre.setChamp(champ);
            arbre.setProductiviteAnnuelle(calculerProductiviteAnnuelle(age));

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

    public double calculerProductiviteAnnuelle(Integer age) {
        if (age < 3) {
            return 2.5;
        } else if (age <= 10) {
            return 12;
        } else {
            return 20;
        }
    }

    private boolean isDatePlantationValide(LocalDate datePlantation) {
        int mois = datePlantation.getMonthValue();
        return mois >= 3 && mois <= 5 && datePlantation.isBefore(LocalDate.now());
    }
}
