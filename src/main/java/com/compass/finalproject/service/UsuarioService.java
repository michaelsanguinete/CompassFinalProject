package com.compass.finalproject.service;

import com.compass.finalproject.DTO.DetalhesDenunciaDTO;
import org.springframework.http.ResponseEntity;

import com.compass.finalproject.DTO.UsuarioDTO;
import com.compass.finalproject.DTO.UsuarioFormDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UsuarioService {
	
	ResponseEntity<UsuarioDTO> save(UsuarioFormDTO formDTO);
	
	ResponseEntity<UsuarioDTO> update(int id, UsuarioFormDTO formDTO);

	ResponseEntity<List<DetalhesDenunciaDTO>> denunciasDoUsuario(@PathVariable int id);
	
	

}
