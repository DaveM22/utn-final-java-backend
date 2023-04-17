package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.CategoriaDto;
import com.example.utnfinaljava.entities.Categoria;

public interface CategoriaService {
    public List<CategoriaDto> listaCategorias();

    public Categoria guardarCategoria(Categoria categoria);

    public void borrarCategoria(Long id);
}
