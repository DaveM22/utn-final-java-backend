package com.example.utnfinaljava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.entities.Location;
import com.example.utnfinaljava.repositories.LocationRepository;

@Service
public class LocationService {
    
    @Autowired
    LocationRepository repository;

    public List<Location> ListaLocalidades(){
        return repository.findAll();
    }

    public Location GuardarLocalidad(Location localidad){
        if(localidad.getCodigo() == null){
            localidad.setCodigo(0L);
        }
        return repository.save(localidad);
    }

    public void BorrarLocalidad(Long id){
        Location loc = repository.findById(id).get();
        repository.delete(loc);
    }
}
