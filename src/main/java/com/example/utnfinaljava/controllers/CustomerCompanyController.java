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

import com.example.utnfinaljava.dtos.CustomerCompanyDto;
import com.example.utnfinaljava.interfaces.CustomerCompanyService;
import com.example.utnfinaljava.responses.ResponseRequest;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerCompanyController {
    
    private final CustomerCompanyService customerCompanyService;

    @GetMapping("/customer/company")
    public ResponseEntity<ResponseRequest> getParticular(){
        ResponseRequest response = new ResponseRequest();
        List<CustomerCompanyDto> dtos = customerCompanyService.getAll();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/customer/company")
    public ResponseEntity<ResponseRequest> postParticular(@RequestBody CustomerCompanyDto persona){
        ResponseRequest response = new ResponseRequest();
        CustomerCompanyDto dto = customerCompanyService.create(persona);
        response.setPayload(dto);
        response.setMessage("Se ha creado el cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/customer/company")
    public ResponseEntity<ResponseRequest> putParticular(@RequestBody CustomerCompanyDto persona){
        ResponseRequest response = new ResponseRequest();
        CustomerCompanyDto dto = customerCompanyService.edit(persona);
        response.setPayload(dto);
        response.setMessage("Se han guardado los cambios del cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/customer/company/{id}")
    public ResponseEntity<ResponseRequest> delete(@PathVariable("id") Long id){
        ResponseRequest response = new ResponseRequest();
        customerCompanyService.delete(id);
        response.setMessage("Se ha borrado el cliente de manera exitosa");
        return ResponseEntity.ok(response);
    }
}
