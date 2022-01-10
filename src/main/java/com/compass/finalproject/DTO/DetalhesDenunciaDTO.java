package com.compass.finalproject.DTO;

import java.time.LocalDateTime;

import com.compass.finalproject.entity.Animais;
import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.Endereco;
import com.compass.finalproject.entity.OrgaoResponsavel;
import com.compass.finalproject.entity.StatusDenuncia;
import com.compass.finalproject.entity.Usuario;

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


    public DetalhesDenunciaDTO(Denuncias denuncia, Animais animais, Endereco endereco, OrgaoResponsavel orgaoResponsavel, Usuario usuario){

        this.id = denuncia.getId();
        this.mensagem = denuncia.getMensagem();

        this.nomeDenunciante = usuario.getNome();
        this.nomeOrgaoResponsavel = orgaoResponsavel.getNome();

        this.tipoAnimal = animais.getTipo();
        this.raca = animais.getRaca();
        this.cor = animais.getCor();

        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.cep = endereco.getCep();

        this.statusDenuncia = denuncia.getStatus();

        this.dataCriacao = denuncia.getDataCriacao();
    }
}   
