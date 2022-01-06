package com.compass.finalproject.repository;

import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncias, Integer>{

     List<Denuncias> findByTipoAnimal_Tipo(AnimaisEnum animal);
}
