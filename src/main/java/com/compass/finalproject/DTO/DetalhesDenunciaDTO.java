package com.compass.finalproject.DTO;

import java.time.LocalDateTime;

import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.StatusDenuncia;
import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dataCriacao;


    public DetalhesDenunciaDTO(Denuncias denuncia){

        this.id = denuncia.getId();
        this.mensagem = denuncia.getMensagem();

        if(denuncia.getDenunciante() != null){
            this.nomeDenunciante = denuncia.getDenunciante().getNome();
        }
       if(denuncia.getOrgaoResponsavel()!= null){
        this.nomeOrgaoResponsavel = denuncia.getOrgaoResponsavel().getNome();
       }

        this.tipoAnimal = denuncia.getAnimal().getTipo();
        this.raca = denuncia.getAnimal().getRaca();
        this.cor = denuncia.getAnimal().getCor();

        this.logradouro = denuncia.getEnderecoDenuncia().getLogradouro();
        this.numero = denuncia.getEnderecoDenuncia().getNumero();
        this.complemento = denuncia.getEnderecoDenuncia().getComplemento();
        this.bairro = denuncia.getEnderecoDenuncia().getBairro();
        this.cidade = denuncia.getEnderecoDenuncia().getCidade();
        this.estado = denuncia.getEnderecoDenuncia().getEstado();
        this.cep = denuncia.getEnderecoDenuncia().getCep();

        this.statusDenuncia = denuncia.getStatus();

        this.dataCriacao = denuncia.getDataCriacao();
    }
}   
