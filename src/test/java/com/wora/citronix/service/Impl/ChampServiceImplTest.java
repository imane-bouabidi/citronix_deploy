package com.wora.citronix.service.Impl;

import com.wora.citronix.Mappers.ChampMapper;
import com.wora.citronix.dtos.champ.ChampCreateDTO;
import com.wora.citronix.dtos.champ.ChampDTO;
import com.wora.citronix.dtos.champ.ChampUpdateDTO;
import com.wora.citronix.entities.Champ;
import com.wora.citronix.entities.Ferme;
import com.wora.citronix.exceptions.EntityNotFoundException;
import com.wora.citronix.repositories.ChampRepository;
import com.wora.citronix.repositories.FermeRepository;
import com.wora.citronix.services.ServiceImpl.ChampServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChampServiceImplTest {

    @Mock
    private ChampRepository champRepo;

    @Mock
    private FermeRepository fermeRepository;

    @Mock
    private ChampMapper champMapper;

    @InjectMocks
    private ChampServiceImpl champService;

    private ChampCreateDTO createDTO;
    private ChampUpdateDTO updateDTO;
    private ChampDTO champDTO;
    private Champ champ;
    private Ferme ferme;

    @BeforeEach
    void setUp() {
        ferme = new Ferme();
        ferme.setId(1L);
        ferme.setSuperficie(10000.0);

        champ = new Champ();
        champ.setId(1L);
        champ.setSuperficie((long) 2000);
        champ.setFerme(ferme);

        createDTO = new ChampCreateDTO();
        createDTO.setFermeId(1L);
        createDTO.setSuperficie((long)2000);

        updateDTO = new ChampUpdateDTO();
        updateDTO.setId(1L);
        updateDTO.setSuperficie((long)2500);

        champDTO = new ChampDTO();
        champDTO.setId(1L);
        champDTO.setSuperficie((long)2000);
    }

    @Test
    void saveChamp_Success() {
        when(fermeRepository.findById(any())).thenReturn(Optional.of(ferme));
        when(champMapper.toEntity(any(ChampCreateDTO.class))).thenReturn(champ);
        when(champRepo.save(any())).thenReturn(champ);
        when(champMapper.toDTO(any())).thenReturn(champDTO);

        ChampDTO result = champService.save(createDTO);

        assertNotNull(result);
        assertEquals(champDTO.getId(), result.getId());
        verify(champRepo).save(any());
    }

    @Test
    void saveChamp_FermeNotFound() {
        when(fermeRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> champService.save(createDTO));
    }

    @Test
    void updateChamp_Success() {
        when(champRepo.findById(any())).thenReturn(Optional.of(champ));
        when(champRepo.save(any())).thenReturn(champ);
        when(champMapper.toDTO(any())).thenReturn(champDTO);

        ChampDTO result = champService.update(updateDTO);

        assertNotNull(result);
        assertEquals(champDTO.getId(), result.getId());
        verify(champRepo).save(any());
    }

    @Test
    void updateChamp_NotFound() {
        when(champRepo.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> champService.update(updateDTO));
    }

    @Test
    void deleteChamp_Success() {
        when(champRepo.findById(any())).thenReturn(Optional.of(champ));

        champService.delete(1L);

        verify(champRepo).delete(any());
    }

    @Test
    void deleteChamp_NotFound() {
        when(champRepo.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> champService.delete(1L));
    }

    @Test
    void findChampById_Success() {
        when(champRepo.findById(any())).thenReturn(Optional.of(champ));
        when(champMapper.toDTO(any())).thenReturn(champDTO);

        ChampDTO result = champService.findById(1L);

        assertNotNull(result);
        assertEquals(champDTO.getId(), result.getId());
    }

    @Test
    void findChampById_NotFound() {
        when(champRepo.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> champService.findById(1L));
    }
}

