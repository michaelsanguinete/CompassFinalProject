package com.compass.finalproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nome;
	@OneToOne
	@NotNull
	private Endereco enderecoUsuario;
	@NotNull
	private String telefone;
	@NotNull
	private String email;
	@NotNull
	private String senha;
	@OneToMany
	private List<Denuncias> listaDenuncias = new ArrayList<Denuncias>();

}
