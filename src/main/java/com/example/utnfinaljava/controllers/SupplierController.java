package com.example.utnfinaljava.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.SupplierDto;
import com.example.utnfinaljava.interfaces.SupplierService;
import com.example.utnfinaljava.responses.ResponseRequest;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/supplier")
    public ResponseEntity<ResponseRequest> get(){
        ResponseRequest response = new ResponseRequest();
        List<SupplierDto> dtos = supplierService.getSupplier();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/supplier")
    public ResponseEntity<ResponseRequest> post(@RequestBody SupplierDto supplier){
        ResponseRequest response = new ResponseRequest();
        SupplierDto dto = supplierService.create(supplier);
        response.setPayload(dto);
        response.setMessage("Se ha creado el proveedor de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/supplier")
    public ResponseEntity<ResponseRequest> put(@RequestBody SupplierDto persona){
        ResponseRequest response = new ResponseRequest();
        SupplierDto dto = supplierService.edit(persona);
        response.setPayload(dto);
        response.setMessage("Se han guardado los cambios del proveedor de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/supplier/{id}")
    public ResponseEntity<ResponseRequest> delete(@PathVariable("id") Long id){
        ResponseRequest response = new ResponseRequest();
        supplierService.delete(id);
        response.setMessage("Se ha borrado el proveedor de manera exitosa");
        return ResponseEntity.ok(response);
    }
}
