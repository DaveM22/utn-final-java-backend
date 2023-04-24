package com.example.utnfinaljava.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.CategoriaDto;
import com.example.utnfinaljava.entities.Category;
import com.example.utnfinaljava.interfaces.CategoryService;
import com.example.utnfinaljava.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoriaDto> listaCategorias() {
        List<Category> entities = categoriaRepository.findAll();
        List<CategoriaDto> dtos = entities.stream()
        .map(a -> modelMapper.map(a, CategoriaDto.class))
        .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public Category guardarCategoria(Category categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void borrarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
    
}
