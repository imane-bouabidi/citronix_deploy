package com.wora.citronix.repositories;

import com.wora.citronix.entities.Ferme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface FermeRepository extends JpaRepository<Ferme,Long> {
    default List<Ferme> rechercherFermes(String nom, String localisation, EntityManager entityManager) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ferme> query = cb.createQuery(Ferme.class);
        Root<Ferme> ferme = query.from(Ferme.class);

        List<Predicate> predicates = new ArrayList<>();

        if (nom != null && !nom.isEmpty()) {
            predicates.add(cb.like(cb.lower(ferme.get("nom")), "%" + nom.toLowerCase() + "%"));
        }
        if (localisation != null && !localisation.isEmpty()) {
            predicates.add(cb.like(cb.lower(ferme.get("localisation")), "%" + localisation.toLowerCase() + "%"));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(query).getResultList();
    }
}
