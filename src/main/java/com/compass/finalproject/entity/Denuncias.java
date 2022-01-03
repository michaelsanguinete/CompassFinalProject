package com.compass.finalproject.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Denuncias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mensagem;
	private Usuario denunciante;
	private Animais tipoAnimal;
	private Endereco enderecoDenuncia;
	private StatusDenuncia status = StatusDenuncia.Nao_Tratada;
	private LocalDateTime dataCriacao = LocalDateTime.now();

}
