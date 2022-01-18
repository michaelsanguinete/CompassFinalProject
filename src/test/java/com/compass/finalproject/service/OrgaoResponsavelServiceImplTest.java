package com.compass.finalproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import com.compass.finalproject.DTO.OrgaoResponsavelFormDTO;
import com.compass.finalproject.entity.Animais;
import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.Endereco;
import com.compass.finalproject.entity.OrgaoResponsavel;
import com.compass.finalproject.entity.StatusDenuncia;
import com.compass.finalproject.repository.DenunciaRepository;
import com.compass.finalproject.repository.EnderecoRepository;
import com.compass.finalproject.repository.OrgaoReponsavelRepository;
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
public class OrgaoResponsavelServiceImplTest {

    
    @MockBean
    private OrgaoReponsavelRepository orgaoReponsavelRepository;

 
    @Autowired
    private OrgaoResponsavelService orgaoResponsavelService;
    
    @MockBean
    private DenunciaRepository denunciaRepository;

    @MockBean
    private EnderecoRepository enderecoRepository;

    @Test
    public void deveriaRetornarNotFoundAUmOrgaoInexistenteNoList(){
        MockitoAnnotations.openMocks(this);
        Optional<OrgaoResponsavel> orgaoResponsavelOptional = Optional.empty();
        Mockito.when(orgaoReponsavelRepository.findById(-1)).thenReturn(orgaoResponsavelOptional);
        assertEquals(ResponseEntity.notFound().build(), orgaoResponsavelService.listDenuncias(-1));
    }

    @Test
    public void deveriaRetornarNotFoundComUmIdInexistenteNoUptade(){
        MockitoAnnotations.openMocks(this);
        Endereco endereco = new Endereco(10000, "Rua das dalias", "MG", "Casa", "Jardim ipe", "Lagoa Santa", 29, 332232323);
        OrgaoResponsavelFormDTO formDTO = new OrgaoResponsavelFormDTO("Breno", endereco, "993949595", "breno@gmail.com", "12345");
        Optional<OrgaoResponsavel> orgaoResponsavelOptional = Optional.empty();
        Mockito.when(this.orgaoReponsavelRepository.findById(-1)).thenReturn(orgaoResponsavelOptional);
        assertEquals(ResponseEntity.notFound().build(), orgaoResponsavelService.uptadeOrgaoResponsavel(-1, formDTO));
    }

    @Test
    public void deveriaRetornarOkParaAlterarOsStatusDaDenuncia(){
        MockitoAnnotations.openMocks(this);
        Endereco endereco = new Endereco(10000, "Rua das dalias", "MG", "Casa", "Jardim ipe", "Lagoa Santa", 29, 332232323);
        OrgaoResponsavel orgaoResponsavel = new OrgaoResponsavel(2, "CCPD", endereco, "999323232", Collections.emptyList(),"orgao@email.com", "1234");
        Animais animal = new Animais(5, AnimaisEnum.Cachorro, "pitbull", "branco");
        Denuncias denuncia = new Denuncias(10, "Maus tratos a meu cachorro", null, orgaoResponsavel, animal, endereco, StatusDenuncia.Aberto, LocalDateTime.now(), null, null);
        Mockito.when(this.orgaoReponsavelRepository.getById(1)).thenReturn(orgaoResponsavel);
        Mockito.when(this.denunciaRepository.findById(1)).thenReturn(Optional.of(denuncia));
        assertEquals(ResponseEntity.ok().build(), orgaoResponsavelService.alteraStatusDenuncia(1));
    }

}
