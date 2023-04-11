package com.example.utnfinaljava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.entities.Provincia;
import com.example.utnfinaljava.services.ProvinciaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProvinciaController {
    
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/provincias")
    public List<Provincia> GetProvincias(){
        return provinciaService.GetProvincias();
    }
}
