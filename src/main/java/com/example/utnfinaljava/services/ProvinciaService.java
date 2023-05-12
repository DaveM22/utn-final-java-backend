package com.example.utnfinaljava.services;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.utnfinaljava.dtos.ProvinceDto;
import com.example.utnfinaljava.entities.Province;
import com.example.utnfinaljava.repositories.ProvinceRepository;
import com.example.utnfinaljava.util.exceptions.AlreadyExistException;
import com.example.utnfinaljava.util.exceptions.NotExistException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProvinciaService {

    private final ProvinceRepository provinciaRepository;


    public List<ProvinceDto> getProvincies() {

        var entities = provinciaRepository.findAll();
        List<ProvinceDto> provincies = new ArrayList<ProvinceDto>();
        for (Province provincie : entities) {
            ProvinceDto dto = new ProvinceDto();
            dto.setProvinceCode(provincie.getCodeProvince());
            dto.setName(provincie.getName());
            provincies.add(dto);
        }
        return provincies;
    }

    @Transactional
    public ProvinceDto create(ProvinceDto province) throws AlreadyExistException {
        boolean alreadyExist = provinciaRepository.existsById(province.getProvinceCode());
        if (alreadyExist) {
            throw new AlreadyExistException("El código de la provincia ingresado ya existe");
        }

        Province entity = new Province();
        entity.setCodeProvince(province.getProvinceCode());
        entity.setName(province.getName());
        provinciaRepository.save(entity);
        return province;
    }

    @Transactional
    public ProvinceDto edit(ProvinceDto province) throws NotExistException {
        boolean notExist = !provinciaRepository.existsById(province.getProvinceCode());
        if (notExist) {
            throw new NotExistException("La provincia ingresada no existe");
        }
        Province entity = new Province();
        entity.setCodeProvince(province.getProvinceCode());
        entity.setName(province.getName());
        provinciaRepository.save(entity);
        return province;
    }

    @Transactional
    public void delete(Long provinceId) throws NotExistException {
        boolean notExist = !provinciaRepository.existsById(provinceId);
        if (notExist) {
            throw new NotExistException("La provincia ingresada no existe");
        }
        provinciaRepository.deleteById(provinceId);
    }
}
