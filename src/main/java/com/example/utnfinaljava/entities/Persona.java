package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;
    @Column(name = "direccion")
    private String direction;
    @Column(name = "telefono")
    private String phoneNumber;
    @Column(name = "direccion_email")
    private String email;
    @OneToOne
    @JoinColumn(name = "cod_postal", referencedColumnName = "cod_postal", insertable = true, updatable = true)
    private Location location;
}
