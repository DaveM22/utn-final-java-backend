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
import com.example.utnfinaljava.entities.Location;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.services.LocationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class LocalidadController {

    @Autowired
    private LocationService localidadService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/localidades")
    public List<Location> GetLocalidades(){
        return localidadService.ListaLocalidades();
    }

    @PostMapping("/localidades/nuevo")
    public ResponseEntity<?> AgregarLocalidad(@Valid @RequestBody LocalidadDto localidad, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Location loc = modelMapper.map(localidad, Location.class);
        localidadService.GuardarLocalidad(loc);
        return new ResponseEntity<String>("La localidad se ha creado correctamente",HttpStatus.OK);
    }

    @PutMapping("/localidades")
    @ResponseBody
    public ResponseRequest EditarLocalidad(@RequestBody Location localidad){
        Location entity = localidadService.GuardarLocalidad(localidad);
        LocalidadDto dto = modelMapper.map(entity, LocalidadDto.class);
        return new ResponseRequest("","Se ha modificado la localidad correctamente", dto);
    }

    @DeleteMapping("/localidades/{codigo}")
    public ResponseEntity<ResponseRequest> BorrarLocalidad(@PathVariable("codigo") Long codigo){
        localidadService.BorrarLocalidad(codigo);
        return ResponseEntity.ok(new ResponseRequest("","La localidad se ha borrado correctamente",null));
    }        
}
