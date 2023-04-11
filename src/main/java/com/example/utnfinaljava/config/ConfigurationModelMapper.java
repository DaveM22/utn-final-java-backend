package com.example.utnfinaljava.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.utnfinaljava.dtos.LocalidadDto;
import com.example.utnfinaljava.dtos.ProvinciaDto;
import com.example.utnfinaljava.entities.Localidad;
import com.example.utnfinaljava.entities.Provincia;
@Configuration
public class ConfigurationModelMapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(ProvinciaDto.class, Provincia.class);
        modelMapper.createTypeMap(LocalidadDto.class, Localidad.class);
        return modelMapper;
    }
}
