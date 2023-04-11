package com.example.utnfinaljava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.entities.Provincia;
import com.example.utnfinaljava.repositories.ProvinciaRepository;

@Service
public class ProvinciaService {
    
    @Autowired
    private ProvinciaRepository provinciaRepository;

    public List<Provincia> GetProvincias(){
        return provinciaRepository.findAll();
    }
}
