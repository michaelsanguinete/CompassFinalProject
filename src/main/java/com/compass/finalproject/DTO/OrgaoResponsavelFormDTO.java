package com.compass.finalproject.DTO;

import com.compass.finalproject.entity.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgaoResponsavelFormDTO {
    private int id;
	private String nome;
	private Endereco endereco;
	private String telefone;
	private String email;
	private String senha;
}
