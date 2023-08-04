package com.example.utnfinaljava.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.utnfinaljava.dtos.LocationDto;
import com.example.utnfinaljava.responses.ResponseRequest;
import com.example.utnfinaljava.services.LocationServiceImpl;
import com.example.utnfinaljava.util.error.ErrorMessages;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    private LocationServiceImpl locationService;

    @GetMapping("/locations")
    public ResponseEntity<ResponseRequest<List<LocationDto>>> getAll(){
        ResponseRequest<List<LocationDto>> response = new ResponseRequest<List<LocationDto>>();
        List<LocationDto> dtos = locationService.getLocations();
        response.setPayload(dtos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/locations")
    public ResponseEntity<ResponseRequest<?>> post(@Valid @RequestBody LocationDto location) {
        ResponseRequest<LocationDto> response = new ResponseRequest<LocationDto>();
                    LocationDto created = locationService.create(location);
            response.setMessage("Se ha creado la localidad de manera exitosa");
            response.setPayload(created);
            return ResponseEntity.ok(response);
    }

    @PutMapping("/locations")
    @ResponseBody
    public ResponseEntity<ResponseRequest<?>> putLocation(@Valid @RequestBody LocationDto location) throws AlreadyExistException, NotExistException{
        ResponseRequest<LocationDto> response = new ResponseRequest<LocationDto>();
        LocationDto edited = locationService.edit(location);
        response.setMessage("Se han guardado los cambios de la localidad de manera exitosa");
        response.setPayload(edited);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/locations/{code}")
    public ResponseEntity<ResponseRequest<?>> delete(@PathVariable("code") Long code) throws NotExistException{
        ResponseRequest<?> response = new ResponseRequest<Object>();
        locationService.delete(code);
        response.setMessage("Se ha borrado la localidad de manera exitosa");
        return ResponseEntity.ok(response);
    }        
}
