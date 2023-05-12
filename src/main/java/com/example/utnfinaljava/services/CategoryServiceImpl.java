package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.CategoryDto;
import com.example.utnfinaljava.dtos.CustomerParticularDto;
import com.example.utnfinaljava.entities.Category;
import com.example.utnfinaljava.interfaces.CategoryService;
import com.example.utnfinaljava.repositories.CategoryRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<CategoryDto> getCategories() {
        List<Category> entities = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
        for (Category category : entities) {
            CategoryDto dto = new CategoryDto();
            dto.setCategoryId(category.getId());
            dto.setName(category.getName());
            categoryDtos.add(dto);
        }
        return categoryDtos;
    }

    @Override
    @Transactional
    public CategoryDto createCategory(CategoryDto category) {
        Category cat = new Category();
        cat.setName(category.getName());
        categoryRepository.save(cat);
        return category;
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CategoryDto editCategoriaDto(CategoryDto category) {
        Category cat = new Category();
        cat.setId(category.getCategoryId());
        cat.setName(category.getName());
        categoryRepository.save(cat);
        return category;
    }
    
}
