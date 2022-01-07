package com.compass.finalproject.DTO;

import java.time.LocalDateTime;

import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.StatusDenuncia;

import lombok.Data;

@Data
public class DetalhesDenunciaDTO {
    private int id;
    private String mensagem;

    private String nomeDenunciante;
    private String nomeOrgaoResponsavel;

    private AnimaisEnum tipoAnimal;
    private String raca;
    private String cor;

    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;

    private StatusDenuncia statusDenuncia;

    private LocalDateTime dataCriacao;


    public DetalhesDenunciaDTO(Denuncias denuncia){

    }
}   
