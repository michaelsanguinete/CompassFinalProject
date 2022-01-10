package com.compass.finalproject.service;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.DenunciaFormDTO;
import com.compass.finalproject.DTO.DenunciaSaveFormDTO;

import java.util.ArrayList;
import java.util.List;

import com.compass.finalproject.DTO.DetalhesDenunciaDTO;
import com.compass.finalproject.entity.Animais;
import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.Endereco;
import com.compass.finalproject.entity.OrgaoResponsavel;
import com.compass.finalproject.entity.StatusDenuncia;
import com.compass.finalproject.entity.Usuario;
import com.compass.finalproject.repository.AnimaisRepository;
import com.compass.finalproject.repository.DenunciaRepository;
import com.compass.finalproject.repository.EnderecoRepository;
import com.compass.finalproject.repository.OrgaoReponsavelRepository;
import com.compass.finalproject.repository.UsuarioRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DenunciaServiceImpl implements DenunciaService {

	@Autowired
	DenunciaRepository denunciaRepository;

	@Autowired
	AnimaisRepository animaisRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	OrgaoReponsavelRepository orgaoReponsavelRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<DenunciaDTO> save(DenunciaSaveFormDTO formDTO) {
		try {
			// Salva o Endereco no bando de dados
			Endereco enderecoDenuncia = this.enderecoRepository
					.save(modelMapper.map(formDTO.getEnderecoDenuncia(), Endereco.class));

			// Salva animal no banco
			Animais animalSalvo = this.animaisRepository.save(modelMapper.map(formDTO.getTipoAnimal(), Animais.class));

			// Busca informações do usuário no banco
			Usuario usuario = this.usuarioRepository.getById(formDTO.getDenunciante());

			// Atribui informações de Endereço Tipo de Animal e Usuario a denúncia
			Denuncias denuncia = modelMapper.map(formDTO, Denuncias.class);
			denuncia.setEnderecoDenuncia(enderecoDenuncia);
			denuncia.setAnimal(animalSalvo);
			denuncia.setDenunciante(usuario);

			// Salva Denuncia no banco
			Denuncias denunciaSalva = this.denunciaRepository.save(denuncia);

			return ResponseEntity.ok().build();

		} catch (Exception e) {
			e.printStackTrace(); // Método temporário
			throw new RuntimeException(); // Método temporário
		}
	}

	@Override
	public ResponseEntity<List<DetalhesDenunciaDTO>> list() {

		List<Denuncias> denuncias = denunciaRepository.findAll();
		List<Animais> animais = animaisRepository.findAll();
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Endereco> enderecos = enderecoRepository.findAll();
		List<OrgaoResponsavel> orgaoResponsaveis = orgaoReponsavelRepository.findAll();

		List<DetalhesDenunciaDTO> detalhesDenunciaDTOs = new ArrayList<>();

		denuncias.forEach(de -> detalhesDenunciaDTOs.add(new DetalhesDenunciaDTO(de,
				animais.get(de.getAnimal().getId()), enderecos.get(de.getEnderecoDenuncia().getId()),
				orgaoResponsaveis.get(de.getOrgaoResponsavel().getId()), usuarios.get(de.getDenunciante().getId()))));

		return ResponseEntity.ok(detalhesDenunciaDTOs);

	}

	@Override
	public ResponseEntity<DenunciaDTO> update(int id, DenunciaFormDTO formDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		denunciaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<DenunciaDTO> getDenuncia(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<DenunciaDTO>> listAnimais(AnimaisEnum tipoAnimal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<StatusDenuncia> listStatus(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
