package com.compass.finalproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
	@OneToMany(mappedBy = "denunciante_id")
	private List<Denuncias> listaDenuncias = new ArrayList<Denuncias>();

}
