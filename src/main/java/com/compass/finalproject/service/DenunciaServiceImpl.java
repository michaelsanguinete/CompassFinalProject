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
public class DenunciaServiceImpl implements DenunciaService{

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
        Denuncias denuncia = modelMapper.map(formDTO, Denuncias.class);
        Denuncias denunciaSalva = this.denunciaRepository.save(denuncia);
        System.out.println(denunciaSalva);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<DetalhesDenunciaDTO>> list() {
        
        List<Denuncias> denuncias = denunciaRepository.findAll();
        List<Animais> animais = animaisRepository.findAll();
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<Endereco> enderecos = enderecoRepository.findAll();
        List<OrgaoResponsavel> orgaoResponsaveis = orgaoReponsavelRepository.findAll();

        List<DetalhesDenunciaDTO> detalhesDenunciaDTOs = new ArrayList<>();

        denuncias.forEach(de ->
            detalhesDenunciaDTOs.add(new DetalhesDenunciaDTO(de, animais.get(de.getTipo_animal_id())
            , enderecos.get(de.getEndereco_denuncia_id())
            , orgaoResponsaveis.get(de.getOrgao_responsavel_id())
            , usuarios.get(de.getDenunciante_id())))  
        );

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
