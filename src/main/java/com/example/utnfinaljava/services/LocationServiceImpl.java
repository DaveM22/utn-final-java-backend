package com.example.utnfinaljava.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.utnfinaljava.config.mappers.LocationMapper;
import com.example.utnfinaljava.dtos.LocationDto;
import com.example.utnfinaljava.entities.Location;
import com.example.utnfinaljava.interfaces.LocationService;
import com.example.utnfinaljava.repositories.LocationRepository;
import com.example.utnfinaljava.repositories.ProvinceRepository;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    private final ProvinceRepository provinceRepository;

    private final LocationMapper locationMapper;

    public List<LocationDto> getLocations() {
        List<Location> entities = locationRepository.findAll();
        return locationMapper.locationListToLocationListDto(entities);
    }

    @Transactional
    public LocationDto create(LocationDto location) throws AlreadyExistException, NotExistException {
        boolean alreadyExist = locationRepository.existsById(location.getPostalCode());
        if (alreadyExist) {
            throw new AlreadyExistException("El código de la provincia ingresado ya existe");
        }

        boolean provinceNotExist = !provinceRepository.existsById(location.getProvinceCode());
        if (provinceNotExist) {
            throw new NotExistException("La provincia ingresada no existe");
        }

        Location loc = locationMapper.locationDtoToLocation(location);
        Location saved = locationRepository.save(loc);
        location = locationMapper.locationToLocationDto(saved);
        return location;
    }

    @Override
    @Transactional
    public LocationDto edit(LocationDto location) throws NotExistException {

        boolean provinceNotExist = !provinceRepository.existsById(location.getPostalCode());
        if (!provinceNotExist) {
            throw new NotExistException("La provincia ingresada no existe");
        }

        Location loc = locationMapper.locationDtoToLocation(location);
        Location saved = locationRepository.save(loc);
        return locationMapper.locationToLocationDto(saved);
    }

    @Transactional
    public void delete(Long id) throws NotExistException {
        boolean notExist = !locationRepository.existsById(id);
        if (notExist) {
            throw new NotExistException("La provincia ingresada no existe");
        }
        locationRepository.deleteById(id);
    }
}
