package com.compass.finalproject.repository;

import com.compass.finalproject.entity.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
	Optional<Usuario> findByEmail(String email);
}
