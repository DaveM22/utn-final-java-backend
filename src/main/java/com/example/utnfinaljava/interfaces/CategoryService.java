package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.CategoryDto;


public interface CategoryService {
    public List<CategoryDto> getAll();

    public CategoryDto create(CategoryDto category);

    public CategoryDto edit(CategoryDto category);

    public void delete(Long id);
}
