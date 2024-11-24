package com.wora.citronix.controllers;

import com.wora.citronix.dtos.detail_recolte.DetailRecolteDTO;
import com.wora.citronix.dtos.detail_recolte.DetailRecolteUpdateDTO;
import com.wora.citronix.entities.EmbeddedId.EmbeddedArbreRecolteId;
import com.wora.citronix.services.ServiceInerf.DetailRecolteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detailRecoltes")
@RequiredArgsConstructor
public class DetailRecolteController {

    private final DetailRecolteService detailRecolteService;

    @PutMapping
    public ResponseEntity<DetailRecolteDTO> updateDetailRecolte(@RequestBody @Valid DetailRecolteUpdateDTO detailRecolteUpdateDTO) {
        DetailRecolteDTO savedDetailRecolte = detailRecolteService.update(detailRecolteUpdateDTO);
        return ResponseEntity.ok(savedDetailRecolte);
    }

    @GetMapping("/suivi-arbre-recolte")
    public ResponseEntity<DetailRecolteDTO> obtenirDetailRecolte(
            @RequestParam Long recolteId, @RequestParam Long arbreId) {
        DetailRecolteDTO detailRecolteDTO = detailRecolteService.findByRecolteIdAndArbreId(recolteId, arbreId);
        return ResponseEntity.ok(detailRecolteDTO);
    }
}
