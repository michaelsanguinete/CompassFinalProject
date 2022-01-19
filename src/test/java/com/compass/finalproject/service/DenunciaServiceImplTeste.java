package com.compass.finalproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.compass.finalproject.DTO.DenunciaSaveFormDTO;
import com.compass.finalproject.entity.Animais;
import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.Endereco;
import com.compass.finalproject.entity.StatusDenuncia;
import com.compass.finalproject.entity.Usuario;
import com.compass.finalproject.repository.AnimaisRepository;
import com.compass.finalproject.repository.DenunciaRepository;
import com.compass.finalproject.repository.UsuarioRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DenunciaServiceImplTeste {
    
    @MockBean
    UsuarioRepository usuarioRepository;

    @Autowired
    DenunciaService denunciaService;

    @MockBean
    AnimaisRepository animaisRepository;

    @MockBean
    DenunciaRepository denunciaRepository;

    @Test
    public void deveriaRetornarCreatedNoPost(){
        MockitoAnnotations.openMocks(this);
        Animais animal = new Animais(5, AnimaisEnum.Cachorro, "pitbull", "branco");
        Endereco enderecoDenuncia = new Endereco(10000, "Rua das dalias", "MG", "Casa", "Jardim ipe", "Lagoa Santa", 29, 332232323);
        DenunciaSaveFormDTO denunciaSaveFormDTO = new DenunciaSaveFormDTO("Maus Tratos de cachorro na minha rua", 1, animal, enderecoDenuncia);
        
       Usuario usuario = new Usuario(1, "Leonardo", enderecoDenuncia, "999323232","usuario@email.com", "1234",  Collections.emptyList(), null);

       Mockito.when(usuarioRepository.getById(ArgumentMatchers.anyInt())).thenReturn(usuario);

       assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), denunciaService.save(denunciaSaveFormDTO)); 


    }

    @Test
    public void deveriaRetornarOkParaUmAnimalEscritoComLetraMiniscula(){
        MockitoAnnotations.openMocks(this);
        Mockito.when(denunciaRepository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(ResponseEntity.ok(Collections.emptyList()), denunciaService.list(null));
    }

    @Test
    public void deveriaRetornarNotFoundParaUmIdInexistente(){
        MockitoAnnotations.openMocks(this);
        Endereco endereco = new Endereco(10000, "Rua das dalias", "MG", "Casa", "Jardim ipe", "Lagoa Santa", 29, 332232323);
        Usuario usuario = new Usuario(1, "Leonardo", endereco, "999323232","usuario@email.com", "1234",  Collections.emptyList(), null);
        Animais animal = new Animais(5, AnimaisEnum.Cachorro, "pitbull", "branco");
        Denuncias denuncia = new Denuncias(10, "Maus tratos a meu cachorro", usuario, null, animal, endereco, StatusDenuncia.Aberto, LocalDateTime.now(), null, null);
        DenunciaSaveFormDTO denunciaSaveFormDTO = new DenunciaSaveFormDTO(denuncia.getMensagem(), usuario.getId(), animal, endereco);
        Mockito.when(this.denunciaRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());

        assertEquals(ResponseEntity.notFound().build(), denunciaService.update(-1, denunciaSaveFormDTO)); 
    }

    @Test
    public void deveriaRetornarNotFoundSeNaoEncontrarNadaNoBanco(){
        MockitoAnnotations.openMocks(this);
        Optional<Denuncias> denuncia = Optional.empty();
        Mockito.when(denunciaRepository.findById(1)).thenReturn(denuncia);
        assertEquals(ResponseEntity.notFound().build(), denunciaService.getDenuncia(1)); 
    }
}