package com.wora.citronix.repositories;

import com.wora.citronix.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Vente, Long> {
}