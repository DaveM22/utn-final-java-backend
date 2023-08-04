package com.example.utnfinaljava.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.CustomerCompanyDto;
import com.example.utnfinaljava.dtos.ProductDto;
import com.example.utnfinaljava.interfaces.ProductService;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductService productoService;

    @GetMapping("/products")
    public ResponseEntity<ResponseRequest<List<ProductDto>>> getAll(){
        ResponseRequest<List<ProductDto>>response = new ResponseRequest<List<ProductDto>>();
        List<ProductDto> productos = productoService.getProducts();
        response.setPayload(productos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    public ResponseEntity<ResponseRequest<ProductDto>>  post(@Valid @RequestBody ProductDto producto ) {
        ProductDto nuevoProducto = this.productoService.save(producto);
        ResponseRequest<ProductDto> response = new ResponseRequest<ProductDto>();
        response.setMessage("Se ha agregado un nuevo producto de manera correcta");
        response.setPayload(nuevoProducto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/products")
    public ResponseEntity<ResponseRequest<ProductDto>> put(@Valid @RequestBody ProductDto producto  )  {
        ProductDto nuevoProducto = this.productoService.edit(producto);
         ResponseRequest<ProductDto> response = new  ResponseRequest<ProductDto>();
        response.setMessage("Se han guardado los cambios del producto de manera exitosa");
        response.setPayload(nuevoProducto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ResponseRequest<?>> delete(@PathVariable("id") Long id){
        ResponseRequest<?> response = new ResponseRequest<Object>();
        productoService.delete(id);
        response.setMessage("Se ha borrado el producto de manera exitosa");
        return ResponseEntity.ok(response);
    }
}
