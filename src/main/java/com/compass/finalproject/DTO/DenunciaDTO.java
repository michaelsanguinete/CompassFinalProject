package com.compass.finalproject.dto;

import com.compass.finalproject.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DenunciaDTO {
    private int id;
    private String mensagem;
    private Usuario denunciante;
    private OrgaoResponsavel orgaoResponsavel;
    private Animais tipoAnimal;
    private Endereco enderecoDenuncia;
    private StatusDenuncia status;
    private LocalDateTime dataCriacao;
}
