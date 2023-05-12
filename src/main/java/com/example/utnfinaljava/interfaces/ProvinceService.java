package com.example.utnfinaljava.interfaces;

import java.util.List;
import com.example.utnfinaljava.dtos.ProvinceDto;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;

public interface ProvinceService { 
    List<ProvinceDto> getProvincies();
    ProvinceDto create(ProvinceDto province) throws AlreadyExistException;
    ProvinceDto edit(ProvinceDto province) throws NotExistException;
    void delete(Long provinceId) throws NotExistException;
}
