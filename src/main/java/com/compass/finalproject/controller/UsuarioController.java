package com.compass.finalproject.controller;

import javax.transaction.Transactional;

import com.compass.finalproject.DTO.DetalhesDenunciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.compass.finalproject.DTO.UsuarioDTO;
import com.compass.finalproject.DTO.UsuarioFormDTO;
import com.compass.finalproject.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDTO> save (@RequestBody UsuarioFormDTO body){
		return this.usuarioService.save(body);
	}
	
	@GetMapping("/{id}/denuncias")
	@Transactional
	public ResponseEntity<List<DetalhesDenunciaDTO>> denunciasDoUsuario(@PathVariable int id){
		return this.usuarioService.denunciasDoUsuario(id);
	}

}
