package com.wora.citronix.repositories;

import com.wora.citronix.entities.Recolte;
import com.wora.citronix.entities.enums.Saison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecolteRepository extends JpaRepository<Recolte, Long> {
    boolean existsBySaison(Saison season);
}
