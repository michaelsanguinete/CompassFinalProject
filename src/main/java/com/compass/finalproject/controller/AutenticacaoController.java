package com.compass.finalproject.controller;

import javax.validation.Valid;

import com.compass.finalproject.DTO.LoginForm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    

    @PostMapping
    public ResponseEntity<?> autenticar(@Valid @RequestBody LoginForm form){
        
        System.out.println(form.getEmail()); //temporario
        System.out.println(form.getSenha()); // temporario
        
        return ResponseEntity.ok().build();
    }
}
