package com.compass.finalproject.DTO;

import com.compass.finalproject.entity.Endereco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	
	private int id;
	private String nome;
	private Endereco endereco;
	private String telefone;
	private String email;

}
