package com.example.utnfinaljava.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.CategoriaDto;
import com.example.utnfinaljava.entities.Categoria;
import com.example.utnfinaljava.interfaces.CategoriaService;
import com.example.utnfinaljava.responses.ResponseRequest;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/categorias")
    public ResponseRequest GetCategorias(){
        ResponseRequest response = new ResponseRequest();
        response.setPayload(categoriaService.listaCategorias());
        return response;
    }

    @PostMapping("/categorias")
    public ResponseEntity<ResponseRequest> CrearCategoria(@Valid @RequestBody CategoriaDto categoria, BindingResult result  ){
        ResponseRequest response = new ResponseRequest();
        Categoria loc = modelMapper.map(categoria, Categoria.class);
        categoriaService.guardarCategoria(loc);
        response.setMessage("Se ha creado la categoría de manera exitosa");
        response.setPayload(loc);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/categorias")
    public ResponseEntity<ResponseRequest> EditarCategorias(@Valid @RequestBody CategoriaDto categoria, BindingResult result  ){
        ResponseRequest response = new ResponseRequest();
        Categoria loc = modelMapper.map(categoria, Categoria.class);
        categoriaService.guardarCategoria(loc);
        response.setMessage("Se han guardado los cambios de la categoría de manera exitosa");
        response.setPayload(loc);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<ResponseRequest> borrarCategoria(@PathVariable("id") Long id){
        ResponseRequest response = new ResponseRequest();
        categoriaService.borrarCategoria(id);
        response.setMessage("La categoría se ha borrado correctamente");
        return ResponseEntity.ok(response);
    }   
}
