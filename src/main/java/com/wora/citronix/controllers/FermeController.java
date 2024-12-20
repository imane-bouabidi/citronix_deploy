package com.wora.citronix.controllers;

import com.wora.citronix.dtos.ferme.FermeCreateDTO;
import com.wora.citronix.dtos.ferme.FermeDTO;
import com.wora.citronix.dtos.ferme.FermeSearchDTO;
import com.wora.citronix.dtos.ferme.FermeUpdateDTO;
import com.wora.citronix.services.ServiceInerf.FermeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fermes")
@RequiredArgsConstructor
public class FermeController {
    private final FermeService fermeService;

    @PostMapping
    public ResponseEntity<FermeDTO> createFerme(@RequestBody @Valid FermeCreateDTO fermeCreateDTO) {
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


    @GetMapping
    public ResponseEntity<List<FermeDTO>> getAllFermes(@RequestParam int page, @RequestParam int size) {
        List<FermeDTO> ferms = fermeService.findAll(page, size);
        return ResponseEntity.ok(ferms);
    }

    @GetMapping("/recherche")
    public ResponseEntity<List<FermeDTO>> rechercherFermes(@RequestBody @Valid FermeSearchDTO searchDTO) {
        List<FermeDTO> fermes = fermeService.rechercherFermes(searchDTO);
        if (fermes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fermes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fermeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
