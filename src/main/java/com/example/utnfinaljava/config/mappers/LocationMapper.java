package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.utnfinaljava.dtos.LocationDto;
import com.example.utnfinaljava.entities.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    @Mapping(source = "province.provinceCode", target = "provinceCode")
    @Mapping(source = "province.name", target = "name")
    LocationDto locationToLocationDto(Location loc);

    @Mapping(source = "provinceCode", target = "province.provinceCode")
    Location locationDtoToLocation(LocationDto dto);
    
    List<LocationDto> locationListToLocationListDto(List<Location> locations);
}
