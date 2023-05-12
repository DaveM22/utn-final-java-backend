package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "provincias")
public class Province {
    @Id
    @Column(name = "cod_provincia")
    public Long codeProvince;
    @Column(name = "nombre_provincia")
    public String name;
}
