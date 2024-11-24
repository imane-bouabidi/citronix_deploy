package com.wora.citronix.repositories;

import com.wora.citronix.entities.DetailRecolte;
import com.wora.citronix.entities.Recolte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRecolteRepository extends JpaRepository<DetailRecolte, Integer> {
}
