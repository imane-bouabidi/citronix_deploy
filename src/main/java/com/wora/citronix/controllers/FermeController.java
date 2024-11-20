package com.wora.citronix.controllers;

import com.wora.citronix.dtos.ferme.FermeCreateDTO;
import com.wora.citronix.dtos.ferme.FermeDTO;
import com.wora.citronix.repositories.FermeRepository;
import com.wora.citronix.services.ServiceInerf.FermeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fermes")
@RequiredArgsConstructor
public class FermeController {
    private final FermeRepository fermeRepo;
    private final FermeService fermeService;

    @PostMapping
    public ResponseEntity<FermeDTO> createFerme(@RequestBody @Valid FermeCreateDTO fermeCreateDTO) {
        System.out.println("faaarararara : " + fermeCreateDTO);
        FermeDTO savedVisit = fermeService.save(fermeCreateDTO);
        return ResponseEntity.status(201).body(savedVisit);
    }
}
