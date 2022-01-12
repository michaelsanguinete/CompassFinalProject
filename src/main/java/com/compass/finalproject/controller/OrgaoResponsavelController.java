package com.compass.finalproject.controller;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelDTO;
import com.compass.finalproject.DTO.OrgaoResponsavelFormDTO;
import com.compass.finalproject.service.OrgaoResponsavelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orgaoresponsavel")
public class OrgaoResponsavelController {
    
    @Autowired
    private OrgaoResponsavelService orgaoResponsavelService;

    @PostMapping
    @Transactional
    public ResponseEntity<OrgaoResponsavelDTO> save(@RequestBody OrgaoResponsavelFormDTO body){
        return this.orgaoResponsavelService.save(body);
    }

    @GetMapping("/{id}/denuncia")
    @Transactional
    public ResponseEntity<DenunciaDTO> listDenuncias(@PathVariable int id){
        return this.orgaoResponsavelService.listDenuncias(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<OrgaoResponsavelDTO> uptadeOrgaoResponsavel(@PathVariable int id, @RequestBody OrgaoResponsavelFormDTO body){
        return this.orgaoResponsavelService.uptadeOrgaoResponsavel(id, body);
    }
}
