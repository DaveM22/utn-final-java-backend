package com.example.utnfinaljava.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "localidades")
public class Localidad {
    @Id
    @Column(name = "cod_postal")
    private Long codigo;

    @Column(name = "ciudad")
    private String ciudad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_provincia", referencedColumnName = "cod_provincia")
    private Provincia Provincia;
}
