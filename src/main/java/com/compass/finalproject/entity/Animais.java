package com.compass.finalproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Animais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private AnimaisEnum tipo;
	private String raca;
	private String cor;
	@OneToOne
	private Denuncias denuncia;
}
