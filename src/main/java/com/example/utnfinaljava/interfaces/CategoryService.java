package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.CategoriaDto;
import com.example.utnfinaljava.entities.Category;


public interface CategoryService {
    public List<CategoriaDto> listaCategorias();

    public Category guardarCategoria(Category categoria);

    public void borrarCategoria(Long id);
}
