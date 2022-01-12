package com.compass.finalproject.DTO;

import java.util.List;

import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgaoResponsavelDTO {
    
    private int id;
	private String nome;
	private Endereco endereco;
	private String telefone;
	private List<Denuncias> listaDenuncias;
	private String email;
}
