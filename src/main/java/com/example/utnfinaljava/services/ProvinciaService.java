package com.example.utnfinaljava.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.ProvinciaDto;
import com.example.utnfinaljava.entities.Province;
import com.example.utnfinaljava.repositories.ProvinceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProvinciaService {
    
    private final ProvinceRepository provinciaRepository;

    private final ModelMapper modelMapper;

    public List<Province> GetProvincias(){
        return provinciaRepository.findAll();
    }

    public ProvinciaDto Save(ProvinciaDto province){
        Province entity = modelMapper.map(province, Province.class);
        provinciaRepository.save(entity);
        ProvinciaDto dto = modelMapper.map(entity, ProvinciaDto.class);
        return dto;
    }
}
