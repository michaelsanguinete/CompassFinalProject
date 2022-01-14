package com.compass.finalproject.controller;

import com.compass.finalproject.DTO.DenunciaDTO;
import com.compass.finalproject.DTO.DenunciaSaveFormDTO;
import com.compass.finalproject.DTO.DetalhesDenunciaDTO;
import com.compass.finalproject.service.DenunciaService;
import com.compass.finalproject.service.OrgaoResponsavelService;
import com.compass.finalproject.service.UsuarioService;
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

	@Autowired
	private OrgaoResponsavelService orgaoResponsavelService;

	@GetMapping
	@Transactional
	public ResponseEntity<List<DetalhesDenunciaDTO>> listDenuncias(@RequestParam(required = false) String tipoAnimal) {
		return this.denunciaService.list(tipoAnimal);
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<DenunciaDTO> getDenuncia(@PathVariable int id) {
		return this.denunciaService.getDenuncia(id);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteDenuncia(@PathVariable int id) {
		return this.denunciaService.delete(id);

	}

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DenunciaDTO> updateDenuncia(@PathVariable int id, @RequestBody DenunciaSaveFormDTO body){
        return this.denunciaService.update(id, body);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DenunciaDTO> save(@RequestBody DenunciaSaveFormDTO body){
        return this.denunciaService.save(body);
    }

	@PutMapping("/alterarStatus/{id}")
	@Transactional
	public ResponseEntity<?> alterarStatusID(@PathVariable int id){
		return this.orgaoResponsavelService.alteraStatusDenuncia(id);
	}

}
