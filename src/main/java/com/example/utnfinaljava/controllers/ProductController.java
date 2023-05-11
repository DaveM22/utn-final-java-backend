package com.example.utnfinaljava.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
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
import com.example.utnfinaljava.dtos.ProductDto;
import com.example.utnfinaljava.interfaces.ProductService;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductService productoService;

    @GetMapping("/products")
    public ResponseRequest getProducts(){
        ResponseRequest response = new ResponseRequest();
        List<ProductDto> productos = productoService.getProducts();
        response.setPayload(productos);
        return response;
    }

    @PostMapping("/products")
    public ResponseRequest postProduct(@RequestBody ProductDto producto, BindingResult result ) throws AlreadyExistException{
        ProductDto nuevoProducto = this.productoService.save(producto);
        ResponseRequest response = new ResponseRequest();
        response.setMessage("Se ha agregado un nuevo producto de manera correcta");
        response.setPayload(nuevoProducto);
        return response;
    }

    @PutMapping("/products")
    public ResponseRequest putProduct(@RequestBody ProductDto producto, BindingResult result ) throws NotExistException {
        ProductDto nuevoProducto = this.productoService.edit(producto);
        ResponseRequest response = new ResponseRequest();
        response.setMessage("Se han guardado los cambios del producto de manera exitosa");
        response.setPayload(nuevoProducto);
        return response;
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ResponseRequest> deleteProduct(@PathVariable("id") Long id){
        ResponseRequest response = new ResponseRequest();
        try{
            productoService.delete(id);
            response.setMessage("Se ha borrado el producto de manera exitosa");
            return ResponseEntity.ok(response);
        }
        catch(Exception e){
            response.setErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }
}
