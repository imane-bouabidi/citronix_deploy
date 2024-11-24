package com.wora.citronix.controllers;

import com.wora.citronix.dtos.vente.VenteCreateDTO;
import com.wora.citronix.dtos.vente.VenteDTO;
import com.wora.citronix.services.ServiceInerf.VenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventes")
@RequiredArgsConstructor
public class VenteController {

    private final VenteService venteService;

    @PostMapping
    public ResponseEntity<VenteDTO> saveVente(@RequestBody @Valid VenteCreateDTO venteCreateDTO) {
        VenteDTO vente = venteService.save(venteCreateDTO);
        return ResponseEntity.ok(vente);
    }

    @GetMapping("revenu")
    public ResponseEntity<VenteDTO> getVenteRevenu(@RequestParam Long id) {
        VenteDTO vente = venteService.getVenteRevenu(id);
        return ResponseEntity.ok(vente);
    }
}
