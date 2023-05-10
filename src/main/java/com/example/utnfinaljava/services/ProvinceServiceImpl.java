package com.example.utnfinaljava.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.utnfinaljava.dtos.ProvinceDto;
import com.example.utnfinaljava.entities.Province;
import com.example.utnfinaljava.interfaces.ProvinceService;
import com.example.utnfinaljava.repositories.ProvinceRepository;

public class ProvinceServiceImpl implements ProvinceService {


    @Autowired
    ProvinceRepository provinciaRepository;

    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public List<ProvinceDto> ListaProvincias() {
        List<Province> entities = provinciaRepository.findAll();
        List<ProvinceDto> dtos = entities.stream()
        .map(a -> modelMapper.map(a, ProvinceDto.class))
        .collect(Collectors.toList());
        return dtos;
    }
    
}
