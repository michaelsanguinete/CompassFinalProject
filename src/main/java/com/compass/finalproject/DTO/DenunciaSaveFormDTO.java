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
    private int denunciante_id;
    private Animais tipo_animal;
    private Endereco enderecoDenuncia;

}
