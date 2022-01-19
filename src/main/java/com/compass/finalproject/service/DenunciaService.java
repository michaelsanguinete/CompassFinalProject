package com.compass.finalproject.service;

import com.compass.finalproject.DTO.DenunciaDTO;

import com.compass.finalproject.DTO.DenunciaSaveFormDTO;

import com.compass.finalproject.DTO.DetalhesDenunciaDTO;

import com.compass.finalproject.entity.StatusDenuncia;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DenunciaService {
    
    ResponseEntity<DenunciaDTO> save(DenunciaSaveFormDTO formDTO);

    ResponseEntity<List<DetalhesDenunciaDTO>> list(String tipoAnimal);

    ResponseEntity<DenunciaDTO> update(int id, DenunciaSaveFormDTO formDTO);

    ResponseEntity<?> delete(int id);

    ResponseEntity<DenunciaDTO> getDenuncia(int id);

    ResponseEntity<StatusDenuncia> listStatus(int id);

}
