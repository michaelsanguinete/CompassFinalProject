package com.compass.finalproject.repository;

import com.compass.finalproject.entity.Animais;

import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimaisRepository extends JpaRepository<Animais, Integer>{

    Optional<List<Animais>> findByTipoEquals(AnimaisEnum tipoAnimal);
    
}
