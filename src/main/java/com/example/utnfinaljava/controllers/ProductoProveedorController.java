package com.example.utnfinaljava.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.ProductoProveedorDto;
import com.example.utnfinaljava.dtos.ProductoProveedorListaDto;
import com.example.utnfinaljava.interfaces.ProductoProveedorService;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.services.ProductoProveedorServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ProductoProveedorController {
    
    @Autowired
    ProductoProveedorService productoProveedorServiceImpl;


    @GetMapping("/productos-proveedores/{idProducto}")
    public ResponseRequest ListaProductosProveedor(@PathVariable("idProducto") Long idProducto){
        ResponseRequest response = new ResponseRequest();
        ProductoProveedorListaDto productoProveedorListaDto = productoProveedorServiceImpl.ListaProductosProveedor(idProducto);
        response.setMessage("Proveedores del producto: " + productoProveedorListaDto.getNombreProducto());
        response.setPayload(productoProveedorListaDto.getProductoProveedores());  
        return response;
    }

}
