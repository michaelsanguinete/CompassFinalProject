package com.compass.finalproject.repository;

import java.util.List;

import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DenunciaRepository extends JpaRepository<Denuncias, Integer>{

     List<Denuncias> findByTipoAnimal_Tipo(AnimaisEnum animal);
}
