package com.compass.finalproject.repository;

import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class DenunciaRepositoryTest {

    @Autowired
    private DenunciaRepository denunciaRepository;


    // @Test
    // public  void deveriaEncontrarPeloMenosUmaDenunciaPorTipoAnimal(){
    //     AnimaisEnum tipoAnimal = AnimaisEnum.Cachorro;
    //     List<Denuncias> denuncia = denunciaRepository.findByTipoAnimal_Tipo(tipoAnimal);
    //     System.out.println(denuncia);
    //     Assert.assertNotNull(denuncia);
    // }




}
