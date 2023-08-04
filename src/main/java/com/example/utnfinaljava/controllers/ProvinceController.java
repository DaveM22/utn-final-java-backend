package com.example.utnfinaljava.controllers;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
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

import com.example.utnfinaljava.dtos.ProvinceDto;
import com.example.utnfinaljava.interfaces.ProvinceService;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProvinceController {
    
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public ResponseEntity<ResponseRequest<List<ProvinceDto>>> getAll(){
        ResponseRequest<List<ProvinceDto>>response = new ResponseRequest<List<ProvinceDto>>();
        response.setPayload(provinceService.getProvincies());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/provinces")
    public ResponseEntity<ResponseRequest<ProvinceDto>> post(@Valid @RequestBody ProvinceDto province){
        ResponseRequest<ProvinceDto> response = new ResponseRequest<ProvinceDto>();
        ProvinceDto created = provinceService.create(province);
        response.setMessage("Se ha creado la provincia de manera exitosa");
        response.setPayload(created);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/provinces")
    public ResponseEntity<ResponseRequest<ProvinceDto>> put(@Valid @RequestBody ProvinceDto province) {
        ResponseRequest<ProvinceDto> response = new ResponseRequest<ProvinceDto>();
        ProvinceDto created = provinceService.edit(province);
        response.setMessage("Se han guardado los cambios de la provincia de manera exitosa");
        response.setPayload(created);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/provinces/{id}")
    public ResponseEntity<ResponseRequest<?>> delete(@PathVariable("id") Long id) throws NotExistException{
        ResponseRequest<?> response = new ResponseRequest<Object>();
        provinceService.delete(id);
        response.setMessage("Se ha borrado la provincia de manera exitosa");
        return ResponseEntity.ok(response);
    }

}
