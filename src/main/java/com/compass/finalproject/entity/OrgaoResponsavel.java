package com.compass.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ORGAORESPONSAVEL")
@NoArgsConstructor
@AllArgsConstructor
public class OrgaoResponsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nome;
	@OneToOne
	@NotNull
	private Endereco endereco;
	@NotNull
	private String telefone;
	@OneToMany
	private List<Denuncias> listaDenuncias;
	@NotNull
	private String email;
	@NotNull
	private String senha;

}
