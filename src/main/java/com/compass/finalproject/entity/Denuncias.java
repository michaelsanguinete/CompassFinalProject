package com.compass.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Denuncias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mensagem;
	@ManyToOne
	private Usuario denunciante;
	@ManyToOne
	private OrgaoResponsavel orgaoResponsavel;
	@OneToOne
	private Animais animal;
	@OneToOne
	private Endereco enderecoDenuncia;
	@Enumerated(EnumType.STRING)
	private StatusDenuncia status = StatusDenuncia.Aberto;
	@Column(name = "DATACRIACAO")
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private LocalDateTime dataTratativa;
	private LocalDateTime dataConclusao;

}
