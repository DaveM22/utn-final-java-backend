package com.example.utnfinaljava.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.utnfinaljava.dtos.LocalidadDto;
import com.example.utnfinaljava.entities.Localidad;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.services.LocalidadService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class LocalidadController {

    @Autowired
    private LocalidadService localidadService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/localidades")
    public List<Localidad> GetLocalidades(){
        return localidadService.ListaLocalidades();
    }

    @PostMapping("/localidades/nuevo")
    public ResponseEntity<?> AgregarLocalidad(@Valid @RequestBody LocalidadDto localidad, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Localidad loc = modelMapper.map(localidad, Localidad.class);
        localidadService.GuardarLocalidad(loc);
        return new ResponseEntity<String>("La localidad se ha creado correctamente",HttpStatus.OK);
    }

    @PutMapping("/localidades")
    @ResponseBody
    public ResponseRequest EditarLocalidad(@RequestBody Localidad localidad){
        Localidad entity = localidadService.GuardarLocalidad(localidad);
        LocalidadDto dto = modelMapper.map(entity, LocalidadDto.class);
        return new ResponseRequest("","Se ha modificado la localidad correctamente", dto);
    }

    @DeleteMapping("/localidades/{codigo}")
    public ResponseEntity<ResponseRequest> BorrarLocalidad(@PathVariable("codigo") Long codigo){
        localidadService.BorrarLocalidad(codigo);
        return ResponseEntity.ok(new ResponseRequest("","La localidad se ha borrado correctamente",null));
    }        
}
