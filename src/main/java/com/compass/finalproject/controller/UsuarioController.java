package com.compass.finalproject.controller;

import javax.transaction.Transactional;

import com.compass.finalproject.DTO.DetalhesDenunciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	

	@PutMapping
	@Transactional
	public ResponseEntity<UsuarioDTO> update (@PathVariable int id, @RequestBody UsuarioFormDTO body){
		return this.usuarioService.update(id, body);
	}
	
	@GetMapping("/{id}/denuncias")
	@Transactional
	public ResponseEntity<List<DetalhesDenunciaDTO>> denunciasDoUsuario(@PathVariable int id){
		return this.usuarioService.denunciasDoUsuario(id);
	}


}
