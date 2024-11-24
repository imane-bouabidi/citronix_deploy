package com.wora.citronix.controllers;

import com.wora.citronix.dtos.arbre.ArbreCreateDTO;
import com.wora.citronix.dtos.arbre.ArbreDTO;
import com.wora.citronix.dtos.arbre.ArbreUpdateDTO;
import com.wora.citronix.services.ServiceInerf.ArbreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arbres")
@RequiredArgsConstructor
public class ArbreControlleur {
    private final ArbreService arbreService;

    @PostMapping
    public ResponseEntity<ArbreDTO> createArbre(@RequestBody @Valid ArbreCreateDTO arbreCreateDTO) {
        ArbreDTO savedArbre = arbreService.save(arbreCreateDTO);
        return ResponseEntity.status(201).body(savedArbre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArbreDTO> updateArbre(
            @RequestBody @Valid ArbreUpdateDTO arbreUpdateDTO, @RequestParam Long id) {

        ArbreDTO updatedArbre = arbreService.update(arbreUpdateDTO, id);
        return ResponseEntity.ok(updatedArbre);
    }

    @GetMapping
    public ResponseEntity<List<ArbreDTO>> getAllArbres(@RequestParam int page, @RequestParam int size) {
        List<ArbreDTO> ferms = arbreService.findAll(page, size);
        return ResponseEntity.ok(ferms);
    }

    @GetMapping("/by_champ")
    public ResponseEntity<List<ArbreDTO>> getArbresByChampId(@RequestParam Long champId, @RequestParam int page, @RequestParam int size) {
        List<ArbreDTO> ferms = arbreService.findByChampId(champId,page, size);
        return ResponseEntity.ok(ferms);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        arbreService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
