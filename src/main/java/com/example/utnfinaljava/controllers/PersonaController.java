package com.example.utnfinaljava.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.utnfinaljava.dtos.CustomerParticularDto;
import com.example.utnfinaljava.interfaces.CustomerParticularService;
import com.example.utnfinaljava.responses.ResponseRequest;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PersonaController {
    
    private final CustomerParticularService customerParticularService;

    @GetMapping("/customer/particular")
    public ResponseEntity<ResponseRequest> getParticular(){
        ResponseRequest response = new ResponseRequest();
        List<CustomerParticularDto> dtos = customerParticularService.getAll();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/customer/particular")
    public ResponseEntity<ResponseRequest> postParticular(@RequestBody CustomerParticularDto persona){
        ResponseRequest response = new ResponseRequest();
        CustomerParticularDto dto = customerParticularService.create(persona);
        response.setPayload(dto);
        response.setMessage("Se ha creado el cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/customer/particular")
    public ResponseEntity<ResponseRequest> putParticular(@RequestBody CustomerParticularDto persona){
        ResponseRequest response = new ResponseRequest();
        CustomerParticularDto dto = customerParticularService.edit(persona);
        response.setPayload(dto);
        response.setMessage("Se han guardado los cambios del cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }
}
