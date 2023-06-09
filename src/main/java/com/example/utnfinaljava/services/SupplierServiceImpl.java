package com.example.utnfinaljava.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.utnfinaljava.config.mappers.SupplierMapper;
import com.example.utnfinaljava.dtos.SupplierDto;
import com.example.utnfinaljava.entities.Persona;
import com.example.utnfinaljava.entities.Supplier;
import com.example.utnfinaljava.interfaces.SupplierService;
import com.example.utnfinaljava.repositories.PersonaRepository;
import com.example.utnfinaljava.repositories.SupplierRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final PersonaRepository personaRepository;
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public List<SupplierDto> getSupplier() {
        List<Supplier> entities = supplierRepository.findAll();
        List<SupplierDto> dtos = supplierMapper.supplierListToSupplierDtoListDto(entities);
        return dtos;
    }

    @Override
    @Transactional
    public SupplierDto create(SupplierDto supplier) {
        Persona personaEntity = supplierMapper.supplierDtoToPersona(supplier);
        Persona personaSaved = personaRepository.save(personaEntity);
        Supplier entity = supplierMapper.supplierDtoToSupplier(supplier);
        entity.setPersona(personaSaved);
        Supplier saved = supplierRepository.save(entity);
        return supplierMapper.supplierToSupplierDto(saved);
    }

    @Override
    @Transactional
    public SupplierDto edit(SupplierDto supplier) {
        Persona personaEntity = supplierMapper.supplierDtoToPersona(supplier);
        Persona personaSaved = personaRepository.save(personaEntity);
        Supplier entity = supplierMapper.supplierDtoToSupplier(supplier);
        entity.setPersona(personaSaved);
        Supplier saved = supplierRepository.save(entity);
        return supplierMapper.supplierToSupplierDto(saved);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        supplierRepository.deleteById(id);
        personaRepository.deleteById(id);
    }
    
}
