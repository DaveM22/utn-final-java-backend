package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
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

    public List<LocationDto> getLocations() {
        var entities = locationRepository.findAll();
        List<LocationDto> locations = new ArrayList<LocationDto>();
        for (Location location : entities) {
            LocationDto dto = new LocationDto();
            dto.setPostalCode(location.getPostalCode());
            dto.setProvinceCode(location.getCodProvince());
            dto.setCity(location.getCity());
            dto.setProvinceName(location.getProvince().getName());
            locations.add(dto);
        }
        return locations;
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

        Location loc = new Location();
        loc.setPostalCode(location.getPostalCode());
        loc.setCity(location.getCity());
        loc.setCodProvince(location.getProvinceCode());
        
        locationRepository.save(loc);
        return location;
    }

    @Override
    @Transactional
    public LocationDto edit(LocationDto location) throws NotExistException {

        boolean provinceNotExist = !provinceRepository.existsById(location.getProvinceCode());
        if (provinceNotExist) {
            throw new NotExistException("La provincia ingresada no existe");
        }

        Location loc = new Location();
        loc.setPostalCode(location.getPostalCode());
        loc.setCity(location.getCity());
        loc.setCodProvince(location.getProvinceCode());
        locationRepository.save(loc);
        return location;
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
