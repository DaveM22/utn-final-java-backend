package com.example.utnfinaljava.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.CategoryDto;
import com.example.utnfinaljava.interfaces.CategoryService;
import com.example.utnfinaljava.responses.ResponseRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController

@RequestMapping("/api")
public class CategoryController {
    
    @Autowired
    private final CategoryService categoriaService;


    @GetMapping("/categories")
    public ResponseRequest<List<CategoryDto>> getAll(){
        ResponseRequest<List<CategoryDto>> response = new ResponseRequest<List<CategoryDto>>();
        List<CategoryDto> dtos = categoriaService.getAll();
        response.setPayload(dtos);
        return response;
    }

    @PostMapping("/categories")
    public ResponseEntity<ResponseRequest<CategoryDto>> post(@Valid @RequestBody CategoryDto category){
        ResponseRequest<CategoryDto> response = new ResponseRequest<CategoryDto>();
        CategoryDto dto = categoriaService.create(category);
        response.setMessage("Se ha creado la categoría de manera exitosa");
        response.setPayload(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/categories")
    public ResponseEntity<ResponseRequest<CategoryDto>> put(@Valid @RequestBody CategoryDto category  ){
        ResponseRequest<CategoryDto> response = new ResponseRequest<CategoryDto>();
        CategoryDto dto =  categoriaService.edit(category);
        response.setMessage("Se han guardado los cambios de la categoría de manera exitosa");
        response.setPayload(dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<ResponseRequest<Object>> delete(@PathVariable("id") Long id){
        ResponseRequest<Object> response = new ResponseRequest<Object>();
        categoriaService.delete(id);
        response.setMessage("Se ha borrado la categoría de manera exitosa");
        return ResponseEntity.ok(response);
    }   
}
