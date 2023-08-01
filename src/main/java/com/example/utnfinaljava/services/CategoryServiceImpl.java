package com.example.utnfinaljava.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.config.mappers.CategoryMapper;
import com.example.utnfinaljava.dtos.CategoryDto;
import com.example.utnfinaljava.entities.Category;
import com.example.utnfinaljava.interfaces.CategoryService;
import com.example.utnfinaljava.repositories.CategoryRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;


    @Override
    public List<CategoryDto> getCategories() {
        List<Category> entities = categoryRepository.findAll();
        return categoryMapper.categoryListToCategoryListDto(entities);
    }

    @Override
    @Transactional
    public CategoryDto createCategory(CategoryDto category) {
        Category cat = categoryMapper.categoryDtoToCategory(category);
        Category saved = categoryRepository.save(cat);
        CategoryDto dto = categoryMapper.categoryToCategoryDto(saved);
        return dto;
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CategoryDto editCategoriaDto(CategoryDto category) {
        Category cat = categoryMapper.categoryDtoToCategory(category);
        Category saved = categoryRepository.save(cat);
        category = categoryMapper.categoryToCategoryDto(saved);
        return category;
    }
    
}
