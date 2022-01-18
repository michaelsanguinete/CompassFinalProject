package com.compass.finalproject.service;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelFormDTO;

import com.compass.finalproject.entity.Denuncias;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrgaoResponsavelService {

    ResponseEntity<OrgaoResponsavelDTO> save(OrgaoResponsavelFormDTO body);

    ResponseEntity<List<DenunciaDTO>> listDenuncias(int id);

    ResponseEntity<OrgaoResponsavelDTO> uptadeOrgaoResponsavel(int id, OrgaoResponsavelFormDTO body);

    ResponseEntity<?> alteraStatusDenuncia(int id);

    
}
