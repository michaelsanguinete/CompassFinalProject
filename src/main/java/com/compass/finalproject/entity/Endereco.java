package com.compass.finalproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String logradouro;
	@NotNull
	private String estado;
	private String complemento;
	@NotNull
	private String bairro;
	@NotNull
	private String cidade;
	@NotNull
	private int numero;
	@NotNull
	private int cep;

}
