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
import com.compass.finalproject.entity.StatusDenuncia;
import com.compass.finalproject.repository.DenunciaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class DenunciaServiceImpl implements DenunciaService{

    @Autowired
    DenunciaRepository denunciaRepository;

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
