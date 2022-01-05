package com.compass.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rua;
	private String bairro;
	private String cidade;
	private int numero;
	private int cep;

}
