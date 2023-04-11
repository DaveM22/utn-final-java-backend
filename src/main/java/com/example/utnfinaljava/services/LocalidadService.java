package com.example.utnfinaljava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.entities.Localidad;
import com.example.utnfinaljava.repositories.LocalidadRepository;

@Service
public class LocalidadService {
    
    @Autowired
    LocalidadRepository repository;

    public List<Localidad> ListaLocalidades(){
        return repository.findAll();
    }

    public Localidad GuardarLocalidad(Localidad localidad){
        if(localidad.getCodigo() == null){
            localidad.setCodigo(0L);
        }
        return repository.save(localidad);
    }

    public void BorrarLocalidad(Long id){
        Localidad loc = repository.findById(id).get();
        repository.delete(loc);
    }
}
