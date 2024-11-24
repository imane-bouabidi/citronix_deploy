package com.wora.citronix.repositories;

import com.wora.citronix.entities.Arbre;
import com.wora.citronix.entities.DetailRecolte;
import com.wora.citronix.entities.Recolte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRecolteRepository extends JpaRepository<DetailRecolte, Long> {
//    List<DetailRecolte> findByArbre(Arbre arbre);
DetailRecolte findByRecolteIdAndArbreId(Long recolteId, Long arbreId);
}
