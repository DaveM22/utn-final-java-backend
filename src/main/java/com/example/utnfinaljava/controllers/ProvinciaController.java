package com.example.utnfinaljava.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.ProvinciaDto;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.services.ProvinciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProvinciaController {
    
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/provincias")
    public ResponseEntity<ResponseRequest> ListaProvincias(){
        ResponseRequest response = new ResponseRequest();
        response.setPayload(provinciaService.GetProvincias());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/provincias")
    public ResponseEntity<ResponseRequest> AddProvince(@Valid @RequestBody ProvinciaDto province, BindingResult result) {
        ResponseRequest response = new ResponseRequest();
        if(result.hasErrors()){
            response.setErrorMessage("Se detectaron los siguentes errores al intentar crear una provincia");
            List<String> errors = new ArrayList<String>();
            for(FieldError error: result.getFieldErrors()){
                errors.add(error.getDefaultMessage());
            }
            response.setPayload(errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);  
        }
        ProvinciaDto created = provinciaService.Save(province);
        response.setPayload(created);
        return ResponseEntity.ok(response);
    }
}
