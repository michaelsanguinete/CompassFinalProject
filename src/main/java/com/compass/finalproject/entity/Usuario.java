package com.compass.finalproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@OneToOne
	private Endereco endereco;
	private String telefone;
	private String email;
	private String senha;
	@OneToMany(mappedBy = "denunciante")
	private List<Denuncias> listaDenuncias;

}
