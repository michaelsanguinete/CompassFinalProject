package com.compass.finalproject.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	@ManyToOne
	private Usuario denunciante;
	@ManyToOne
	private OrgaoResponsavel orgaoResponsavel;
	@ManyToOne
	private Animais tipoAnimal;
	@OneToOne
	private Endereco enderecoDenuncia;
	@ManyToOne
	private StatusDenuncia status = new StatusDenuncia("Aberto");
	private LocalDateTime dataCriacao = LocalDateTime.now();

}
