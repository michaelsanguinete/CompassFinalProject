package com.compass.finalproject.repository;

import com.compass.finalproject.entity.Animais;
import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import com.compass.finalproject.entity.Endereco;
import com.compass.finalproject.entity.Usuario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class DenunciaRepositoryTest {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
	private TestEntityManager em;


    // @Test
    // public  void deveriaEncontrarPeloMenosUmaDenunciaPorTipoAnimal(){
    //     AnimaisEnum tipoAnimal = AnimaisEnum.Cachorro;
    //     List<Denuncias> denuncia = denunciaRepository.findByTipoAnimal_Tipo(tipoAnimal);
    //     System.out.println(denuncia);
    //     Assert.assertNotNull(denuncia);
    // }

    @Test
    public void deveriaSalvarUmaDenuncia(){
        Endereco endereco = new Endereco();
        endereco.setLogradouro("rua dos zero");
        endereco.setEstado("Minas Gerais");
        endereco.setComplemento("Casa");
        endereco.setBairro("Caiçaras");
        endereco.setCidade("BH");
        endereco.setNumero(40);
        endereco.setCep(23453232);

        Usuario usuario = new Usuario();
        usuario.setNome("Ronaldo Fenomeno");
        usuario.setEnderecoUsuario(endereco);
        usuario.setTelefone("319988989");
        usuario.setEmail("email@email.com");
        usuario.setSenha("uifusof");
        
        Animais animal = new Animais();
        animal.setTipo(AnimaisEnum.Periquito);
        animal.setRaca("raça de passarinho");
        animal.setCor("Amarelo");

        Denuncias denuncia = new Denuncias();
        denuncia.setMensagem("Denuncia à maus tratos a passarinhos");
        denuncia.setDenunciante(usuario);
        denuncia.setAnimal(animal);
        denuncia.setEnderecoDenuncia(endereco);

        em.persist(denuncia);

        denunciaRepository.save(denuncia);
        assertNotNull(denunciaRepository.findById(denuncia.getId()));
        //assertNull(denunciaRepository.findById(denuncia.getId()));
    }

    @Test
    public void deveriaDeletarUmaDenunciaApartirDoId(){
        Endereco endereco = new Endereco();
        endereco.setLogradouro("rua dos zero");
        endereco.setEstado("Minas Gerais");
        endereco.setComplemento("Casa");
        endereco.setBairro("Caiçaras");
        endereco.setCidade("BH");
        endereco.setNumero(40);
        endereco.setCep(23453232);

        Usuario usuario = new Usuario();
        usuario.setNome("Ronaldo Fenomeno");
        usuario.setEnderecoUsuario(endereco);
        usuario.setTelefone("319988989");
        usuario.setEmail("email@email.com");
        usuario.setSenha("uifusof");
        
        Animais animal = new Animais();
        animal.setTipo(AnimaisEnum.Periquito);
        animal.setRaca("raça de passarinho");
        animal.setCor("Amarelo");

        Denuncias denuncia = new Denuncias();
        denuncia.setMensagem("Denuncia à maus tratos a passarinhos");
        denuncia.setDenunciante(usuario);
        denuncia.setAnimal(animal);
        denuncia.setEnderecoDenuncia(endereco);

        em.persist(denuncia);

        denunciaRepository.deleteById(denuncia.getId());
        assertEquals(0, denunciaRepository.count());
        
    }



}
