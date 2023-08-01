package com.example.utnfinaljava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.ProductSupplierDto;
import com.example.utnfinaljava.dtos.ProductSupplierListDto;
import com.example.utnfinaljava.interfaces.ProductSupplierService;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;


@RestController
@RequestMapping("/api")
public class ProductSupplierController {
    
    @Autowired
    ProductSupplierService productoProveedorServiceImpl;


    @GetMapping("/productos-proveedores/{idProducto}")
    public ResponseRequest ListaProductosProveedor(@PathVariable("idProducto") Long idProducto){
        ResponseRequest response = new ResponseRequest();
        ProductSupplierListDto productoProveedorListaDto = productoProveedorServiceImpl.getProductSupplerByProductId(idProducto);
        response.setMessage("Proveedores del producto: " + productoProveedorListaDto.getProductName());
        response.setPayload(productoProveedorListaDto.getProductSuppliers());  
        return response;
    }

    @GetMapping("/productos-proveedores")
    public ResponseEntity<ResponseRequest> getProductsSupplier(){
        ResponseRequest response = new ResponseRequest();
        List<ProductSupplierDto> dtos = this.productoProveedorServiceImpl.getProductSupplier();
        response.setPayload(dtos);
        return ResponseEntity.ok(response); 
    }

    @PostMapping("/product-supplier/{idProducto}/new")
    public ResponseEntity<ResponseRequest> postProductSupplier(@RequestBody ProductSupplierDto productSupplier,@PathVariable("idProducto") Long idProducto) throws AlreadyExistException {
        ResponseRequest response = new ResponseRequest();
        ProductSupplierDto dto = this.productoProveedorServiceImpl.create(productSupplier);
        response.setMessage("Se ha agregado el proveedor al producto de manera exitosa");
        response.setPayload(dto);
        return ResponseEntity.ok(response); 
    }


    @PutMapping("/product-supplier/{idProducto}/edit")
    public ResponseEntity<ResponseRequest> editProductSupplier(@RequestBody ProductSupplierDto productSupplier,@PathVariable("idProducto") Long idProducto) throws AlreadyExistException {
        ResponseRequest response = new ResponseRequest();
        ProductSupplierDto dto = this.productoProveedorServiceImpl.edit(productSupplier);
        response.setMessage("Se ha agregado stock al producto de manera exitosa");
        response.setPayload(dto);
        return ResponseEntity.ok(response); 
    }

    

}
