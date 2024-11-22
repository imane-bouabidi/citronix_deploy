package com.wora.citronix.repositories;

import com.wora.citronix.entities.Arbre;
import com.wora.citronix.entities.Champ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArbreRepository extends JpaRepository<Arbre,Long> {
    Page<Arbre> findByChampId(Long fermeId, Pageable pageable);

}
