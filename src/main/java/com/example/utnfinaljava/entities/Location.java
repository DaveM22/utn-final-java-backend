package com.example.utnfinaljava.entities;

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
public class Location {
    @Id
    @Column(name = "cod_postal")
    private Long codigo;

    @Column(name = "ciudad")
    private String ciudad;

    @OneToOne
    @JoinColumn(name = "cod_provincia", referencedColumnName = "cod_provincia")
    private Province Provincia;
}