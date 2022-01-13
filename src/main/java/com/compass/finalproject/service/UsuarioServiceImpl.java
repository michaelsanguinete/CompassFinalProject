package com.compass.finalproject.service;

import com.compass.finalproject.DTO.DetalhesDenunciaDTO;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.repository.DenunciaRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	DenunciaRepository denunciaRepository;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<DetalhesDenunciaDTO>> denunciasDoUsuario(int id) {
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if (usuario.isPresent()){
			Optional<List<Denuncias>> denuncias =
					this.denunciaRepository.findByDenuncianteIdEquals(usuario.get().getId());
			if (denuncias.isPresent()){
				List<DetalhesDenunciaDTO> detalhesDenunciaDTOS = new ArrayList<>();
				denuncias.get().forEach( de ->{
					detalhesDenunciaDTOS.add(new DetalhesDenunciaDTO(de));
				});
				return  ResponseEntity.ok(detalhesDenunciaDTOS);
			}
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.notFound().build();
	}

}
