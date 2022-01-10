package com.compass.finalproject.DTO;

import com.compass.finalproject.entity.Animais;
import com.compass.finalproject.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DenunciaUpdateFormDTO {
    private int id;
    private String mensagem;
    private int denunciante;
    private Animais tipoAnimal;
    private Endereco enderecoDenuncia;

}
