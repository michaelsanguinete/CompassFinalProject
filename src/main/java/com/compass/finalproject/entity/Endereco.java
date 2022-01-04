package com.compass.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {

	private String rua;
	private String bairro;
	private String cidade;
	private int numero;
	@Id
	private int cep;

}
