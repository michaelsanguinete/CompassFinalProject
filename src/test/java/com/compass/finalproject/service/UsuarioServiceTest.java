package com.compass.finalproject.service;

import com.compass.finalproject.DTO.DetalhesDenunciaDTO;
import com.compass.finalproject.DTO.UsuarioDTO;
import com.compass.finalproject.DTO.UsuarioFormDTO;
import com.compass.finalproject.entity.*;
import com.compass.finalproject.repository.DenunciaRepository;
import com.compass.finalproject.repository.EnderecoRepository;
import com.compass.finalproject.repository.UsuarioRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @MockBean
    private EnderecoRepository enderecoRepository;

    @MockBean
    private DenunciaRepository denunciaRepository;

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveriaSalvarUsuarioRetornandoCreated(){
        UsuarioFormDTO usuarioFormDTO = usuarioFormDTO();
        Mockito.when(usuarioRepository.save(ArgumentMatchers.any(Usuario.class)))
                .thenReturn(modelMapper.map(usuarioFormDTO, Usuario.class));

        ResponseEntity<UsuarioDTO> response = usuarioService.save(usuarioFormDTO);
        Mockito.verify(usuarioRepository).save(ArgumentMatchers.any(Usuario.class));
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void deveriaSalvarEnderecoAntesdeSalvarUsuario(){
        UsuarioFormDTO usuarioFormDTO = usuarioFormDTO();
        Mockito.when(enderecoRepository.save(ArgumentMatchers.any(Endereco.class)))
                .thenReturn(modelMapper.map(usuarioFormDTO.getEnderecoUsuario(), Endereco.class));
        ResponseEntity<UsuarioDTO> response = usuarioService.save(usuarioFormDTO);
        Mockito.verify(enderecoRepository).save(ArgumentMatchers.any(Endereco.class));
    }

    @Test
    public void deveriaAtualizarUsuario(){
        int id = 1;
        UsuarioFormDTO usuarioFormDTO = usuarioFormDTO();
        Mockito.when(usuarioRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.of(usuario()));

        Mockito.when(enderecoRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.of(endereco()));

        ResponseEntity<UsuarioDTO> response = usuarioService.update(id, usuarioFormDTO);
        Usuario usuario = modelMapper.map(usuarioFormDTO, Usuario.class);

        // Verifica se usuario foi buscado
        Mockito.verify(usuarioRepository).findById(ArgumentMatchers.anyInt());

        // Verifica se endereco foi buscado
        Mockito.verify(enderecoRepository).findById(ArgumentMatchers.anyInt());

        // Salvou as alterações no banco e retornou OK
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void deveriaBuscarDenunciasDoUsuario(){
        int id = 1;
        Usuario usuario = usuario();

        Mockito.when(usuarioRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.of(usuario));

        Optional<List<Denuncias>> denuncias = Optional.of(Arrays.asList());
        Mockito.when(denunciaRepository.findByDenuncianteIdEquals(ArgumentMatchers.anyInt()))
                .thenReturn(denuncias);

        ResponseEntity<List<DetalhesDenunciaDTO>> response = usuarioService.denunciasDoUsuario(id);

        // Buscou o usuario no banco
        Mockito.verify(usuarioRepository).findById(ArgumentMatchers.anyInt());

        // Buscou denuncias no banco
        Mockito.verify(denunciaRepository).findByDenuncianteIdEquals(ArgumentMatchers.anyInt());

        // Salvou as alterações no banco e retornou OK
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void NAOdeveriaAtualizarUsuarioPorIdInvalido(){
        int id = -1;
        UsuarioFormDTO usuarioFormDTO = usuarioFormDTO();
        ResponseEntity<UsuarioDTO> response = usuarioService.update(id, usuarioFormDTO);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }


    private UsuarioFormDTO usuarioFormDTO(){
        UsuarioFormDTO usuarioForm = new UsuarioFormDTO();
        usuarioForm.setNome("Fulano");
        usuarioForm.setTelefone("95412345");
        usuarioForm.setEmail("fulano@email.com");
        usuarioForm.setSenha("123456");

        Endereco endereco = new Endereco();
        endereco.setId(15);
        endereco.setLogradouro("Rua flores");
        endereco.setBairro("Jardim");
        endereco.setNumero(123);
        endereco.setCidade("BH");
        endereco.setEstado("MG");
        endereco.setCep(31123456);
        endereco.setComplemento("Ap 03");

        usuarioForm.setEnderecoUsuario(endereco);

        return usuarioForm;
    }

    private Usuario usuario(){
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Fulano");
        usuario.setTelefone("95412345");
        usuario.setEmail("fulano@email.com");
        usuario.setSenha("123456");

        Endereco endereco = new Endereco();
        endereco.setId(15);
        endereco.setLogradouro("Rua flores");
        endereco.setBairro("Jardim");
        endereco.setNumero(123);
        endereco.setCidade("BH");
        endereco.setEstado("MG");
        endereco.setCep(31123456);
        endereco.setComplemento("Ap 03");

        usuario.setEnderecoUsuario(endereco);

        return usuario;
    }

    private Denuncias denuncia(){
        Denuncias denuncia = new Denuncias();
        denuncia.setId(1);
        denuncia.setMensagem("Denuncia de teste");

        OrgaoResponsavel orgaoResponsavel = new OrgaoResponsavel();
        orgaoResponsavel.setNome("Delegacia");
        orgaoResponsavel.setSenha("123456789");
        orgaoResponsavel.setEmail("delegacia@email.com");

        Animais animal = new Animais();
        animal.setTipo(AnimaisEnum.Periquito);
        animal.setRaca("Amarelo");
        animal.setCor("Amarelo");
        animal.setId(5);

        denuncia.setAnimal(animal);

        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNome("Fulano");
        usuario.setTelefone("95412345");
        usuario.setEmail("fulano@email.com");
        usuario.setSenha("123456");

        Endereco endereco = new Endereco();
        endereco.setId(15);
        endereco.setLogradouro("Rua flores");
        endereco.setBairro("Jardim");
        endereco.setNumero(123);
        endereco.setCidade("BH");
        endereco.setEstado("MG");
        endereco.setCep(31123456);
        endereco.setComplemento("Ap 03");

        usuario.setEnderecoUsuario(endereco);

        orgaoResponsavel.setEndereco(endereco);
        denuncia.setOrgaoResponsavel(orgaoResponsavel);
        denuncia.setDenunciante(usuario);

        return denuncia;
    }

    private DetalhesDenunciaDTO detalhesDenunciaDTO(){
        DetalhesDenunciaDTO detalhesDenunciaDTO = new DetalhesDenunciaDTO(denuncia());
        return detalhesDenunciaDTO;
    }

    private Endereco endereco(){
        Endereco endereco = new Endereco();
        endereco.setId(15);
        endereco.setLogradouro("Rua flores");
        endereco.setBairro("Jardim");
        endereco.setNumero(123);
        endereco.setCidade("BH");
        endereco.setEstado("MG");
        endereco.setCep(31123456);
        endereco.setComplemento("Ap 03");
        return  endereco;
    }

}
