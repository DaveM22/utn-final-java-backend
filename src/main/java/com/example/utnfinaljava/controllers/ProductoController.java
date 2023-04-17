package com.example.utnfinaljava.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.example.utnfinaljava.dtos.ProductoDto;
import com.example.utnfinaljava.entities.Producto;
import com.example.utnfinaljava.interfaces.ProductoService;
import com.example.utnfinaljava.responses.ResponseRequest;

import io.micrometer.observation.transport.ResponseContext;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/productos")
    public ResponseRequest ListaProductos(){
        ResponseRequest response = new ResponseRequest();
        List<ProductoDto> productos = productoService.listaProductos();
        response.setPayload(productos);
        return response;
    }

    @PostMapping("/productos")
    public ResponseRequest AgregarProducto(@RequestBody ProductoDto producto, BindingResult result ){
        ProductoDto nuevoProducto = this.productoService.guardarProducto(producto);
        ResponseRequest response = new ResponseRequest();
        response.setMessage("Se ha agregado un nuevo producto de manera correcta");
        response.setPayload(nuevoProducto);
        return response;
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<ResponseRequest> EliminarProducto(@PathVariable("id") Long id){
        ResponseRequest response = new ResponseRequest();
        try{
            productoService.borrarProducto(id);
            response.setMessage("Se ha borrado el producto de manera exitosa");
            return ResponseEntity.ok(response);
        }
        catch(Exception e){
            response.setErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }
}