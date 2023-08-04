package com.example.utnfinaljava.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.utnfinaljava.config.mappers.ProvinceMapper;
import com.example.utnfinaljava.dtos.ProvinceDto;
import com.example.utnfinaljava.entities.Province;
import com.example.utnfinaljava.interfaces.ProvinceService;
import com.example.utnfinaljava.repositories.LocationRepository;
import com.example.utnfinaljava.repositories.ProvinceRepository;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;
import com.example.utnfinaljava.util.exceptions.PersistenceException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinciaRepository;

    private final ProvinceMapper provinceMapper;

    private final LocationRepository locationRepository;
    
    public List<ProvinceDto> getProvincies() 
    {
        List<Province> provinces = provinciaRepository.findAll();
        return provinceMapper.provinceListToProvinceListDto(provinces);
    }

    @Transactional
    public ProvinceDto create(ProvinceDto province) throws AlreadyExistException {
        boolean alreadyExist = provinciaRepository.existsById(province.getProvinceCode());
        if (alreadyExist) {
            throw new AlreadyExistException("El código de la provincia ingresado ya existe");
        }

        Province entity = provinceMapper.provinceDtoToProvince(province);
        Province save = provinciaRepository.save(entity);
        province = provinceMapper.provinceToProvinceDto(save);
        return province;
    }

    @Transactional
    public ProvinceDto edit(ProvinceDto province) throws NotExistException {
        boolean notExist = !provinciaRepository.existsById(province.getProvinceCode());
        if (notExist) {
            throw new NotExistException("La provincia ingresada no existe");
        }
        Province entity = provinceMapper.provinceDtoToProvince(province);
        Province save = provinciaRepository.save(entity);
        province = provinceMapper.provinceToProvinceDto(save);
        return province;
    }

    @Transactional
    public void delete(Long provinceId) throws NotExistException {
        boolean notExist = !provinciaRepository.existsById(provinceId);
        if (notExist) {
            throw new NotExistException("La provincia ingresada no existe");
        }
        boolean exists = locationRepository.existsByProvinceProvinceCode(provinceId);
        if(exists){
            throw new PersistenceException("La provincia pertece a una localidad registrada");
        }
        provinciaRepository.deleteById(provinceId);
    }
}
