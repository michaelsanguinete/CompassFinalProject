package com.compass.finalproject.controller;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.DenunciaFormDTO;
import com.compass.finalproject.DTO.DenunciaSaveFormDTO;
import com.compass.finalproject.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denuncia")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @GetMapping
    @Transactional
    public ResponseEntity<List<DenunciaDTO>> listDenuncias (){
        ResponseEntity<List<DenunciaDTO>> denuncias = this.denunciaService.list();
        return ResponseEntity.ok(denuncias.getBody());
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DenunciaDTO> getDenuncia (@PathVariable int id){
        ResponseEntity<DenunciaDTO> denuncia = this.denunciaService.getDenuncia(id);
        return ResponseEntity.ok(denuncia.getBody());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteDenuncia(@PathVariable int id){
        this.denunciaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DenunciaDTO> updateDenuncia(@PathVariable int id, @RequestBody DenunciaFormDTO body){
        ResponseEntity<DenunciaDTO> denuncia = this.denunciaService.update(id, body);
        return  ResponseEntity.ok(denuncia.getBody());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DenunciaDTO> save(@RequestBody DenunciaSaveFormDTO body){
        ResponseEntity<DenunciaDTO> denuncia = this.denunciaService.save(body);
        return ResponseEntity.ok(denuncia.getBody());
    }


}
