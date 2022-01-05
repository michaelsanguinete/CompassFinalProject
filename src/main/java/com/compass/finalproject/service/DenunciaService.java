package com.compass.finalproject.service;

import java.util.List;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.DenunciaFormDTO;
import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.StatusDenuncia;

import org.springframework.http.ResponseEntity;

public interface DenunciaService {
    
    ResponseEntity<DenunciaDTO> save(DenunciaFormDTO formDTO);

    ResponseEntity<List<DenunciaDTO>> list();

    ResponseEntity<DenunciaDTO> update(int id);

    ResponseEntity<?> delete(int id);

    ResponseEntity<DenunciaDTO> getDenuncia(int id);

    ResponseEntity<List<DenunciaDTO>> listAnimais(AnimaisEnum tipoAnimal);

    ResponseEntity<StatusDenuncia> listStatus(int id);

}
