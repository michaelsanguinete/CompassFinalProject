package com.compass.finalproject.DTO;

import com.compass.finalproject.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenunciaSaveFormDTO {

    private String mensagem;
    private Usuario denunciante;
    private Animais tipoAnimal;
    private Endereco enderecoDenuncia;
    private StatusDenuncia status;

}
