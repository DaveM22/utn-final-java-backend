package com.example.utnfinaljava.config.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.utnfinaljava.dtos.ProvinceDto;
import com.example.utnfinaljava.entities.Province;

@Mapper(componentModel = "spring")
public interface ProvinceMapper {
    ProvinceMapper INSTANCE = Mappers.getMapper(ProvinceMapper.class);


    ProvinceDto provinceToProvinceDto(Province car);
    Province provinceDtoToProvince(ProvinceDto dto);

    List<ProvinceDto> provinceListToProvinceListDto(List<Province> provinces);
}
