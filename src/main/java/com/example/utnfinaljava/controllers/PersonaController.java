package com.example.utnfinaljava.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utnfinaljava.dtos.PersonaDto;
import com.example.utnfinaljava.dtos.CustomerCompanyDto;
import com.example.utnfinaljava.dtos.CustomerParticularDto;
import com.example.utnfinaljava.interfaces.PersonaService;
import com.example.utnfinaljava.responses.ResponseRequest;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PersonaController {
    
    private final PersonaService customerService;

    @GetMapping("/customer/particular")
    public ResponseEntity<ResponseRequest> getParticular(){
        ResponseRequest response = new ResponseRequest();
        List<CustomerParticularDto> dtos = customerService.getCustomerParticular();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/customer/company")
    public ResponseEntity<ResponseRequest> getCompany(){
        ResponseRequest response = new ResponseRequest();
        List<CustomerCompanyDto> dtos = customerService.getCustomerCompany();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/customer/particular")
    public ResponseEntity<ResponseRequest> postParticular(@RequestBody CustomerParticularDto persona){
        ResponseRequest response = new ResponseRequest();
        CustomerParticularDto dto = customerService.save(persona);
        response.setPayload(dto);
        response.setMessage("Se ha creado el cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/customer/company")
    public ResponseEntity<ResponseRequest> postCompany(@RequestBody CustomerCompanyDto persona){
        ResponseRequest response = new ResponseRequest();
        CustomerCompanyDto dto = customerService.save(persona);
        response.setPayload(dto);
        response.setMessage("Se ha creado el cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/customer/particular")
    public ResponseEntity<ResponseRequest> putParticular(@RequestBody CustomerParticularDto persona){
        ResponseRequest response = new ResponseRequest();
        CustomerParticularDto dto = customerService.save(persona);
        response.setPayload(dto);
        response.setMessage("Se han guardado los cambios del cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/customer/company")
    public ResponseEntity<ResponseRequest> putCompany(@RequestBody CustomerCompanyDto persona){
        ResponseRequest response = new ResponseRequest();
        CustomerCompanyDto dto = customerService.save(persona);
        response.setPayload(dto);
        response.setMessage("Se han guardado los cambios del cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/customer/particular/{id}")
    public ResponseEntity<ResponseRequest> deleteParticular(@PathVariable("id") Long id){
        ResponseRequest response = new ResponseRequest();
        customerService.RemoveCustomerParticular(id);
        response.setMessage("Se ha borrado el cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/customer/company/{id}")
    public ResponseEntity<ResponseRequest> deleteCompany(@PathVariable("id") Long id){
        ResponseRequest response = new ResponseRequest();
        customerService.RemoveCustomerParticular(id);
        response.setMessage("Se ha borrado el cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }
}
