package com.example.utnfinaljava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.ProductSupplierDto;
import com.example.utnfinaljava.dtos.ProductoProveedorListaDto;
import com.example.utnfinaljava.interfaces.ProductSupplierService;
import com.example.utnfinaljava.responses.ResponseRequest;


@RestController
@RequestMapping("/api")
public class ProductoProveedorController {
    
    @Autowired
    ProductSupplierService productoProveedorServiceImpl;


    @GetMapping("/productos-proveedores/{idProducto}")
    public ResponseRequest ListaProductosProveedor(@PathVariable("idProducto") Long idProducto){
        ResponseRequest response = new ResponseRequest();
        ProductoProveedorListaDto productoProveedorListaDto = productoProveedorServiceImpl.ListaProductosProveedor(idProducto);
        response.setMessage("Proveedores del producto: " + productoProveedorListaDto.getNombreProducto());
        response.setPayload(productoProveedorListaDto.getProductoProveedores());  
        return response;
    }

    @GetMapping("/productos-proveedores")
    public ResponseEntity<ResponseRequest> getProductsSupplier(){
        ResponseRequest response = new ResponseRequest();
        List<ProductSupplierDto> dtos = this.productoProveedorServiceImpl.listaProductoProveedor();
        response.setPayload(dtos);
        return ResponseEntity.ok(response); 
    }

    @PostMapping("/product-supplier/{idProducto}/new")
    public ResponseEntity<ResponseRequest> postProductSupplier(@RequestBody ProductSupplierDto productSupplier,@PathVariable("idProducto") Long idProducto){
        ResponseRequest response = new ResponseRequest();
        ProductSupplierDto dto = this.productoProveedorServiceImpl.AddProductSupplier(productSupplier);
        response.setMessage("Se ha agregado el proveedor al producto");
        response.setPayload(dto);
        return ResponseEntity.ok(response); 
    }

}
