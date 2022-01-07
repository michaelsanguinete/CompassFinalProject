package com.compass.finalproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Denuncias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mensagem;
	private int denunciante_id;
	private int orgao_responsavel_id;
	private int tipo_animal_id;
	private int endereco_denuncia_id;
	@Enumerated(EnumType.STRING)
	private StatusDenuncia status = StatusDenuncia.Aberto;
	@Column(name = "DATACRIACAO")
	private LocalDateTime dataCriacao = LocalDateTime.now();

}
