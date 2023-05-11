package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.CategoryDto;


public interface CategoryService {
    public List<CategoryDto> getCategories();

    public CategoryDto createCategory(CategoryDto category);

    public CategoryDto editCategoriaDto(CategoryDto category);

    public void deleteCategory(Long id);
}
