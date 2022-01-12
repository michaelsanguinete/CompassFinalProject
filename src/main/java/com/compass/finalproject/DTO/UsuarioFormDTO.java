package com.compass.finalproject.DTO;

import com.compass.finalproject.entity.Endereco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFormDTO {
	
	private String nome;
	private String telefone;
	private String email;
	private String senha;
	private Endereco enderecoUsuario;
	

}
