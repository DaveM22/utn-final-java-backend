package com.example.utnfinaljava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.entities.Localidad;
import com.example.utnfinaljava.repositories.LocalidadRepository;

@RestController
@RequestMapping("/api")
public class LocalidadController {

    @Autowired
    private LocalidadRepository localidadRepository;


    @GetMapping("/localidades")
    public List<Localidad> GetLocalidades(){
        return localidadRepository.findAll();
    }
}
