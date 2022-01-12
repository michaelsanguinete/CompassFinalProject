package com.compass.finalproject.service;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelFormDTO;
import com.compass.finalproject.repository.OrgaoReponsavelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrgaoResponsavelServiceImpl implements OrgaoResponsavelService{

    @Autowired
    OrgaoReponsavelRepository orgaoReponsavelRepository;

    @Override
    public ResponseEntity<OrgaoResponsavelDTO> save(OrgaoResponsavelFormDTO body) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<DenunciaDTO> listDenuncias(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<OrgaoResponsavelDTO> uptadeOrgaoResponsavel(int id, OrgaoResponsavelFormDTO body) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
