package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.DetailRecolteMapper;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteUpdateDTO;
import com.wora.citronix.entities.*;
import com.wora.citronix.repositories.DetailRecolteRepository;
import com.wora.citronix.repositories.RecolteRepository;
import com.wora.citronix.services.ServiceInerf.DetailRecolteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class DetailRecolteServiceImpl implements DetailRecolteService {
    private final DetailRecolteRepository detailRecolteRepository;
    private final DetailRecolteMapper detailRecolteMapper;
    private final RecolteRepository recolteRepository;

//    public DetailRecolteDTO save(DetailRecolteCreateDTO createDto){
//        Arbre arbre = arbreRepository.findById(createDto.getArbreId())
//                .orElseThrow(() -> new EntityNotFoundException("Arbre non trouvée"));
//
//        DetailRecolte detailRecolte = detailRecolteMapper.toEntity(createDto);
//        detailRecolte.setArbre(arbre);
//        return detailRecolteMapper.toDTO(detailRecolteRepository.save(detailRecolte));
//    }

    @Override
    public DetailRecolteDTO update(DetailRecolteUpdateDTO detailRecolteUpdateDTO) {
        DetailRecolte detailRecolte = detailRecolteRepository.findByRecolteIdAndArbreId(detailRecolteUpdateDTO.getRecolteId(), detailRecolteUpdateDTO.getArbreId());

        detailRecolte.setQuantite(detailRecolteUpdateDTO.getQuantite());
        detailRecolteRepository.save(detailRecolte);

        Recolte recolte = detailRecolte.getRecolte();
        double nouvelleQuantiteTotale = recolte.getDetails().stream()
                .mapToDouble(DetailRecolte::getQuantite)
                .sum();
        recolte.setQuantiteTotale(nouvelleQuantiteTotale);

        recolteRepository.save(recolte);

        return detailRecolteMapper.toDTO(detailRecolte);
    }

//    @Override
//    public List<DetailRecolte> findByArbre(Arbre arbre){
//        return detailRecolteRepository.findByArbre(arbre);
//    }
}
