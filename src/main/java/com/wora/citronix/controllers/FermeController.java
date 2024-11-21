package com.wora.citronix.controllers;

import com.wora.citronix.dtos.ferme.FermeCreateDTO;
import com.wora.citronix.dtos.ferme.FermeDTO;
import com.wora.citronix.dtos.ferme.FermeUpdateDTO;
import com.wora.citronix.repositories.FermeRepository;
import com.wora.citronix.services.ServiceInerf.FermeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public ResponseEntity<FermeDTO> updateFerme(
            @RequestBody @Valid FermeUpdateDTO fermeUpdateDTO,
            @PathVariable Long id) {

        FermeDTO updatedFerme = fermeService.update(fermeUpdateDTO, id);

        if (updatedFerme == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedFerme);
    }
}
