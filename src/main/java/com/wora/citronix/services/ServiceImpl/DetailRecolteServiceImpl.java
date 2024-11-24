package com.wora.citronix.services.ServiceImpl;


import com.wora.citronix.Mappers.DetailRecolteMapper;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteCreateDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteDTO;
import com.wora.citronix.entities.Arbre;
import com.wora.citronix.entities.Champ;
import com.wora.citronix.entities.DetailRecolte;
import com.wora.citronix.entities.Ferme;
import com.wora.citronix.repositories.ArbreRepository;
import com.wora.citronix.repositories.DetailRecolteRepository;
import com.wora.citronix.services.ServiceInerf.DetailRecolteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailRecolteServiceImpl implements DetailRecolteService {
    private final ArbreRepository arbreRepository;
    private final DetailRecolteRepository detailRecolteRepository;
    private final DetailRecolteMapper detailRecolteMapper;

    public DetailRecolteDTO save(DetailRecolteCreateDTO createDto){
        Arbre arbre = arbreRepository.findById(createDto.getArbreId())
                .orElseThrow(() -> new EntityNotFoundException("Arbre non trouvée"));

        DetailRecolte detailRecolte = detailRecolteMapper.toEntity(createDto);
        detailRecolte.setArbre(arbre);
        return detailRecolteMapper.toDTO(detailRecolteRepository.save(detailRecolte));
    }
}
