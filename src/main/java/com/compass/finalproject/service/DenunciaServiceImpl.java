package com.compass.finalproject.service;


import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.DenunciaFormDTO;
import com.compass.finalproject.DTO.DenunciaSaveFormDTO;

import java.util.ArrayList;
import java.util.List;

import com.compass.finalproject.DTO.DetalhesDenunciaDTO;
import com.compass.finalproject.entity.*;
import com.compass.finalproject.repository.AnimaisRepository;
import com.compass.finalproject.repository.DenunciaRepository;
import com.compass.finalproject.repository.EnderecoRepository;
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
    EnderecoRepository enderecoRepository;

    @Autowired
    AnimaisRepository animaisRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DenunciaDTO save(DenunciaSaveFormDTO formDTO) {

        try {
            // Salva o Endereco no bando de dados
            Endereco enderecoDenuncia = this.enderecoRepository.save(
                    modelMapper.map(formDTO.getEnderecoDenuncia(), Endereco.class)
            );

            // Salva animal no banco
            Animais animalSalvo = this.animaisRepository.save(
                    modelMapper.map(formDTO.getTipo_animal(), Animais.class)
            );

            // Busca informações do usuário no banco
            Usuario usuario = this.usuarioRepository.getById(formDTO.getDenunciante_id());

            // Atribui informações de Endereço Tipo de Animal e Usuario a denúncia
            Denuncias denuncia = modelMapper.map(formDTO, Denuncias.class);
            denuncia.setEnderecoDenuncia(enderecoDenuncia);
            denuncia.setAnimal(animalSalvo);
            denuncia.setDenunciante(usuario);

            // Salva Denuncia no banco
            Denuncias denunciaSalva = this.denunciaRepository.save(denuncia);

            return modelMapper.map(denunciaSalva, DenunciaDTO.class);

        } catch (Exception e){
            e.printStackTrace();  // Método temporário
            throw new RuntimeException(); // Método temporário
        }
    }

    @Override
    public ResponseEntity<List<DetalhesDenunciaDTO>> list() {
        
        // 
        return null;
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
