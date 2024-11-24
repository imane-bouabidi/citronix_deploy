package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.ChampMapper;
import com.wora.citronix.Mappers.RecolteMapper;
import com.wora.citronix.dtos.recolte.RecolteCreateDTO;
import com.wora.citronix.dtos.recolte.RecolteDTO;
import com.wora.citronix.entities.Arbre;
import com.wora.citronix.entities.Champ;
import com.wora.citronix.entities.DetailRecolte;
import com.wora.citronix.entities.Recolte;
import com.wora.citronix.exceptions.RecolteDoubleSaisonException;
import com.wora.citronix.repositories.RecolteRepository;
import com.wora.citronix.services.ServiceInerf.ChampService;
import com.wora.citronix.services.ServiceInerf.RecolteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecolteServiceImpl implements RecolteService {

    private final RecolteMapper recolteMapper;
    private final RecolteRepository recolteRepository;
    private final ChampService champService;
    private final ChampMapper champMapper;

    @Override
    public RecolteDTO save(RecolteCreateDTO createDto) {
        Champ champ = champMapper.toEntity(champService.findById(createDto.getChampId()));

        if (recolteRepository.existsBySaison(createDto.getSaison())) {
            throw new RecolteDoubleSaisonException("Déja récolté cette saison !! ");
        }

        champ.getArbres().forEach(Arbre::calculerProductivite);

        double total = champ.getArbres().stream()
                .mapToDouble(Arbre::getProductiviteAnnuelle)
                .sum();

        Recolte recolte = recolteMapper.toEntity(createDto);
        recolte.setSaison(createDto.getSaison());
        recolte.setQuantiteTotale(total);
        recolte.setChamp(champ);
        recolte.setDateRecolte(createDto.getDateRecolte());

        List<DetailRecolte> detailRecoltes = champ.getArbres()
                .stream()
                .map(arbre -> {
                    System.out.println(arbre);
                    return new DetailRecolte(arbre.getProductiviteAnnuelle(), arbre, recolte);
                })
                .toList();

        recolte.setDetails(detailRecoltes);

        Recolte savedHarvest = recolteRepository.save(recolte);
        return recolteMapper.toDTO(savedHarvest);
    }

     public RecolteDTO findById(Long id){
         Recolte recolte =   recolteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Champ n'existe pas !"));
         return recolteMapper.toDTO(recolte);
     }
//    RecolteDTO update(RecolteUpdateDTO updateDto, Long id);
//    List<RecolteDTO> findAll(int page, int size);
}
