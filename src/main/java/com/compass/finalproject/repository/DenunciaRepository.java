package com.compass.finalproject.repository;


import com.compass.finalproject.entity.Animais;
import com.compass.finalproject.entity.AnimaisEnum;
import com.compass.finalproject.entity.Denuncias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DenunciaRepository extends JpaRepository<Denuncias, Integer>{

    Optional<Denuncias> findByAnimalIdEquals(int id);

    Optional<List<Denuncias>> findByDenuncianteIdEquals(int id);

    Optional<List<Denuncias>> findByOrgaoResponsavelIdEquals(int id);
}
