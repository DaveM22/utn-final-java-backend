package com.example.utnfinaljava.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.dtos.CategoriaDto;
import com.example.utnfinaljava.entities.Categoria;
import com.example.utnfinaljava.interfaces.CategoriaService;
import com.example.utnfinaljava.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoriaDto> listaCategorias() {
        List<Categoria> entities = categoriaRepository.findAll();
        List<CategoriaDto> dtos = entities.stream()
        .map(a -> modelMapper.map(a, CategoriaDto.class))
        .collect(Collectors.toList());
        return dtos;
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void borrarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
    
}
