package com.compass.finalproject.repository;

import com.compass.finalproject.entity.Animais;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimaisRepository extends JpaRepository<Animais, Integer>{
    
}
