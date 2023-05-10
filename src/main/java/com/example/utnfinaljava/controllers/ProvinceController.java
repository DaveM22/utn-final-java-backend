package com.example.utnfinaljava.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.ProvinceDto;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.services.ProvinciaService;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProvinceController {
    
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/provinces")
    public ResponseEntity<ResponseRequest> getProvincies(){
        ResponseRequest response = new ResponseRequest();
        response.setPayload(provinciaService.getProvincies());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/provinces")
    public ResponseEntity<ResponseRequest> postProvince(@Valid @RequestBody ProvinceDto province, BindingResult result) throws AlreadyExistException {
        ResponseRequest response = new ResponseRequest();
        if(result.hasErrors()){
            response.setErrorMessage("Error al crear la provincia");
            List<String> errores = result.getAllErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
            response.setPayload(errores);
            return ResponseEntity.badRequest().body(response);
        }
        else{
            ProvinceDto created = provinciaService.create(province);
            response.setPayload(created);
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping("/provinces")
    public ResponseEntity<ResponseRequest> putProvince(@Valid @RequestBody ProvinceDto province, BindingResult result) throws NotExistException {
        ResponseRequest response = new ResponseRequest();
        if(result.hasErrors()){
            response.setErrorMessage("Se detectaron los siguientes errores:");
            List<String> errores = result.getAllErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
            response.setPayload(errores);
            return ResponseEntity.badRequest().body(response);
        }
        else{
            ProvinceDto created = provinciaService.edit(province);
            response.setMessage("Se han guardado los cambios de la provincia de manera exitosa");
            response.setPayload(created);
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/provinces/{id}")
    public ResponseEntity<ResponseRequest> deleteCompany(@PathVariable("id") Long id) throws NotExistException{
        ResponseRequest response = new ResponseRequest();
        provinciaService.delete(id);
        response.setMessage("Se ha borrado la provincia de manera exitosa");
        return ResponseEntity.ok(response);
    }

}
