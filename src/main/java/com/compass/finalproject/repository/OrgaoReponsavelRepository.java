package com.compass.finalproject.repository;

import com.compass.finalproject.entity.OrgaoResponsavel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgaoReponsavelRepository extends JpaRepository<OrgaoResponsavel, Integer>{

    OrgaoResponsavel findByTelefone(String string);
    
}
