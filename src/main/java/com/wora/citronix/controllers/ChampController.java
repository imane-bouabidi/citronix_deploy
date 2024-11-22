package com.wora.citronix.controllers;

import com.wora.citronix.dtos.champ.ChampCreateDTO;
import com.wora.citronix.dtos.champ.ChampDTO;
import com.wora.citronix.dtos.champ.ChampUpdateDTO;
import com.wora.citronix.repositories.ChampRepository;
import com.wora.citronix.services.ServiceInerf.ChampService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/champs")
@RequiredArgsConstructor
public class ChampController {
    private final ChampRepository champRepo;
    private final ChampService champService;

    @PostMapping
    public ResponseEntity<ChampDTO> createChamp(@RequestBody @Valid ChampCreateDTO champCreateDTO) {
        ChampDTO savedChamp = champService.save(champCreateDTO);
        return ResponseEntity.status(201).body(savedChamp);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ChampDTO> updateChamp(
//            @RequestBody @Valid ChampUpdateDTO champUpdateDTO,
//            @PathVariable Long id) {
//
//        ChampDTO updatedChamp = champService.update(champUpdateDTO, id);
//
//        if (updatedChamp == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedChamp);
//    }


//    @GetMapping
//    public ResponseEntity<List<ChampDTO>> getAllChamps(@RequestParam int page, @RequestParam int size) {
//        List<ChampDTO> ferms = champService.findAll(page, size);
//        return ResponseEntity.ok(ferms);
//    }

    @GetMapping("/by_ferme")
    public ResponseEntity<List<ChampDTO>> getChampsByFermeId(@RequestParam Long fermeId, @RequestParam int page, @RequestParam int size) {
        List<ChampDTO> ferms = champService.findByFermeId(fermeId,page, size);
        return ResponseEntity.ok(ferms);
    }
}
