package com.example.utnfinaljava.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.utnfinaljava.dtos.ProvinciaDto;
import com.example.utnfinaljava.entities.Provincia;
import com.example.utnfinaljava.interfaces.ProvinciaService;
import com.example.utnfinaljava.repositories.ProvinciaRepository;

public class ProvinciaServiceImpl implements ProvinciaService {


    @Autowired
    ProvinciaRepository provinciaRepository;

    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<ProvinciaDto> ListaProvincias() {
        List<Provincia> entities = provinciaRepository.findAll();
        List<ProvinciaDto> dtos = entities.stream()
        .map(a -> modelMapper.map(a, ProvinciaDto.class))
        .collect(Collectors.toList());
        return dtos;
    }
    
}
