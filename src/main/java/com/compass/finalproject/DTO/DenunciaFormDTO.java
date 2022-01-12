package com.compass.finalproject.DTO;

import com.compass.finalproject.entity.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenunciaFormDTO {
    private String mensagem;
    private Usuario denunciante;
    private OrgaoResponsavel orgaoResponsavel;
    private Animais tipoAnimal;
    private Endereco enderecoDenuncia;
    private StatusDenuncia status;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dataCriacao;
}
