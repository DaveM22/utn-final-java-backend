package com.example.utnfinaljava.interfaces;

import java.util.List;

import com.example.utnfinaljava.dtos.LocationDto;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

public interface LocationService {
    List<LocationDto> getLocations();

    LocationDto create(LocationDto location) throws AlreadyExistException, NotExistException;

    LocationDto edit(LocationDto location) throws NotExistException;

    void delete(Long id) throws NotExistException;
}
