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

	@OneToOne
	private Usuario denunciante;

	@ManyToOne
	@JoinColumn(name="orgao_responsavel_id")
	private OrgaoResponsavel orgaoResponsavel;

	@OneToOne
	private Animais animal;

	@OneToOne
	private Endereco enderecoDenuncia;

	@Enumerated(EnumType.STRING)
	private StatusDenuncia status = StatusDenuncia.Aberto;
	@Column(name = "DATACRIACAO")
	private LocalDateTime dataCriacao = LocalDateTime.now();

}
