package com.example.utnfinaljava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.entities.Provincia;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.services.ProvinciaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
}
