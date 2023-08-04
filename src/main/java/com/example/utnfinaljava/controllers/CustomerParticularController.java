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
import com.example.utnfinaljava.dtos.CustomerParticularDto;
import com.example.utnfinaljava.interfaces.CustomerParticularService;
import com.example.utnfinaljava.responses.ResponseRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerParticularController {
    
    private final CustomerParticularService customerParticularService;

    @GetMapping("/customer/particular")
    public ResponseEntity<ResponseRequest<List<CustomerParticularDto>>> getAll(){
        ResponseRequest<List<CustomerParticularDto>> response = new ResponseRequest<List<CustomerParticularDto>>();
        List<CustomerParticularDto> dtos = customerParticularService.getAll();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/customer/particular")
    public ResponseEntity<ResponseRequest<CustomerParticularDto>> post(@Valid @RequestBody CustomerParticularDto persona){
        ResponseRequest<CustomerParticularDto>response = new ResponseRequest<CustomerParticularDto>();
        CustomerParticularDto dto = customerParticularService.create(persona);
        response.setPayload(dto);
        response.setMessage("Se ha creado el cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/customer/particular")
    public ResponseEntity<ResponseRequest<CustomerParticularDto>> put(@Valid @RequestBody CustomerParticularDto persona){
        ResponseRequest<CustomerParticularDto> response = new ResponseRequest<CustomerParticularDto>();
        CustomerParticularDto dto = customerParticularService.edit(persona);
        response.setPayload(dto);
        response.setMessage("Se han guardado los cambios del cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/customer/particular/{id}")
    public ResponseEntity<ResponseRequest<Object>> delete(@PathVariable("id") Long id){
        ResponseRequest<Object> response = new ResponseRequest<Object>();
        customerParticularService.delete(id);
        response.setMessage("Se ha borrado el cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }
}
