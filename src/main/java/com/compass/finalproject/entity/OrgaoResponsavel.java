package com.compass.finalproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "ORGAORESPONSAVEL")
public class OrgaoResponsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@OneToOne
	private Endereco endereco;
	private String telefone;
	@OneToMany(mappedBy = "orgaoResponsavel")
	private List<Denuncias> listaDenuncias;
	private String email;
	private String senha;

}
