package com.example.utnfinaljava.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.example.utnfinaljava.dtos.ProvinciaDto;
import com.example.utnfinaljava.entities.Province;
import com.example.utnfinaljava.repositories.ProvinceRepository;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProvinciaService {
    
    private final ProvinceRepository provinciaRepository;

    private final ModelMapper modelMapper;

    public List<Province> GetProvincias(){
        return provinciaRepository.findAll();
    }

    public ProvinciaDto New(ProvinciaDto province) throws AlreadyExistException {
        boolean alreadyExist = provinciaRepository.existsById(province.getCode());
        if(alreadyExist){
            throw new AlreadyExistException("El código de la provincia ingresado ya existe");
        }
        Province entity = modelMapper.map(province, Province.class);
        provinciaRepository.save(entity);
        ProvinciaDto dto = modelMapper.map(entity, ProvinciaDto.class);
        return dto;
    }

    public ProvinciaDto Edit(ProvinciaDto province) throws NotExistException {
        boolean notExist = !provinciaRepository.existsById(province.getCode());
        if(notExist){
            throw new NotExistException("La provincia ingresada no existe");
        }
        Province entity = modelMapper.map(province, Province.class);
        provinciaRepository.save(entity);
        ProvinciaDto dto = modelMapper.map(entity, ProvinciaDto.class);
        return dto;
    }
}
