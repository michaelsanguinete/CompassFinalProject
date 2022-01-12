package com.compass.finalproject.service;

import org.springframework.http.ResponseEntity;

import com.compass.finalproject.DTO.UsuarioDTO;
import com.compass.finalproject.DTO.UsuarioFormDTO;

public interface UsuarioService {
	
	ResponseEntity<UsuarioDTO> save(UsuarioFormDTO formDTO);
	
	ResponseEntity<UsuarioDTO> update(int id, UsuarioFormDTO formDTO);
	
	

}
