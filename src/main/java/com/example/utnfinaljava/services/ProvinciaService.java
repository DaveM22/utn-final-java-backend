package com.example.utnfinaljava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.entities.Province;
import com.example.utnfinaljava.repositories.ProvinceRepository;

@Service
public class ProvinciaService {
    
    @Autowired
    private ProvinceRepository provinciaRepository;

    public List<Province> GetProvincias(){
        return provinciaRepository.findAll();
    }
}
