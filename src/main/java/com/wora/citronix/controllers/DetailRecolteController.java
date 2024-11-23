//package com.wora.citronix.controllers;
//
//import com.wora.citronix.dtos.detail_recolte.DetailRecolteCreateDTO;
//import com.wora.citronix.dtos.detail_recolte.DetailRecolteDTO;
//import com.wora.citronix.services.ServiceInerf.DetailRecolteService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/detailRecoltes")
//@RequiredArgsConstructor
//public class DetailRecolteController {
//
//    private final DetailRecolteService detailRecolteService;
//
//    @PostMapping
//    public ResponseEntity<DetailRecolteDTO> createDetailRecolte(@RequestBody @Valid DetailRecolteCreateDTO detailRecolteCreateDTO) {
//        DetailRecolteDTO savedDetailRecolte = detailRecolteService.save(detailRecolteCreateDTO);
//        return ResponseEntity.status(201).body(savedDetailRecolte);
//    }
//}
