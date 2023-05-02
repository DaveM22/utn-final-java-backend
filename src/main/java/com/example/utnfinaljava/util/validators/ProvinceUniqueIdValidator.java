package com.example.utnfinaljava.util.validators;

import com.example.utnfinaljava.repositories.ProvinceRepository;
import com.example.utnfinaljava.services.ProvinciaService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public  class ProvinceUniqueIdValidator implements ConstraintValidator<ProvinceUniqueId, Long>{

    private final ProvinceRepository repository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return !repository.existsById(value);
    }


}
