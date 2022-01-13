package com.compass.finalproject.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.compass.finalproject.DTO.UsuarioDTO;
import com.compass.finalproject.DTO.UsuarioFormDTO;
import com.compass.finalproject.entity.Endereco;
import com.compass.finalproject.entity.Usuario;
import com.compass.finalproject.repository.EnderecoRepository;
import com.compass.finalproject.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<UsuarioDTO> save(UsuarioFormDTO formDTO) {
		try {

		Endereco enderecoUsuario = this.enderecoRepository.save(modelMapper.map(formDTO.getEnderecoUsuario(), Endereco.class));
		Usuario usuario = modelMapper.map(formDTO, Usuario.class);
		usuario.setEnderecoUsuario(enderecoUsuario);
		usuarioRepository.save(usuario);
	

		return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch (Exception e) {
			e.printStackTrace(); 
			return ResponseEntity.internalServerError().build(); 
		}
	}

	@Override
	public ResponseEntity<UsuarioDTO> update(int id, UsuarioFormDTO formDTO) {
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			Optional<Endereco> endereco = this.enderecoRepository.findById(usuario.get().getEnderecoUsuario().getId());
			endereco.get().setBairro(formDTO.getEnderecoUsuario().getBairro());
			endereco.get().setCep(formDTO.getEnderecoUsuario().getCep());
			endereco.get().setCidade(formDTO.getEnderecoUsuario().getCidade());
			endereco.get().setComplemento(formDTO.getEnderecoUsuario().getComplemento());
			endereco.get().setEstado(formDTO.getEnderecoUsuario().getEstado());
			endereco.get().setLogradouro(formDTO.getEnderecoUsuario().getLogradouro());
			endereco.get().setNumero(formDTO.getEnderecoUsuario().getNumero());
			
			usuario.get().setEmail(formDTO.getEmail());
			usuario.get().setNome(formDTO.getNome());
			usuario.get().setSenha(formDTO.getSenha());
			usuario.get().setTelefone(formDTO.getTelefone());
			
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
