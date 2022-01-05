package com.compass.finalproject.service;

import java.util.List;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.DenunciaFormDTO;
import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.StatusDenuncia;
import com.compass.finalproject.repository.DenunciaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class DenunciaServiceImpl implements DenunciaService{

    @Autowired
    DenunciaRepository denunciaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<DenunciaDTO> save(DenunciaFormDTO formDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<List<DenunciaDTO>> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<DenunciaDTO> update(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        // TODO Auto-generated method stub
        return null;
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
