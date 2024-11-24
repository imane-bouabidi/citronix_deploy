package com.wora.citronix.repositories;

import com.wora.citronix.entities.Recolte;
import com.wora.citronix.entities.enums.Saison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecolteRepository extends JpaRepository<Recolte, Integer> {
    boolean existsBySaison(Saison season);
}
