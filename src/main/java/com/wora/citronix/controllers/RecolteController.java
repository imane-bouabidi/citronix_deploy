package com.wora.citronix.controllers;

import com.wora.citronix.dtos.recolte.RecolteCreateDTO;
import com.wora.citronix.dtos.recolte.RecolteDTO;
import com.wora.citronix.services.ServiceImpl.RecolteServiceImpl;
import com.wora.citronix.services.ServiceInerf.RecolteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recoltes")
@RequiredArgsConstructor
public class RecolteController {


    private final RecolteService recolteService;

    @PostMapping
    public ResponseEntity<RecolteDTO> createRecolte(@RequestBody @Valid RecolteCreateDTO recolteCreateDTO) {
        RecolteDTO savedVisit = recolteService.save(recolteCreateDTO);
        return ResponseEntity.status(201).body(savedVisit);
    }
}
