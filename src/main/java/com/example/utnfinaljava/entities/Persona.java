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
@Table(name = "personas")
public class Persona {
    @Id
    @Column(name = "cuit")
    private String cuit;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion_email")
    private String email;
    @Column(name = "pagina_web")
    private String paginaWeb;
    @OneToOne
    @JoinColumn(name = "cod_postal", referencedColumnName = "cod_postal")
    private Localidad localidad;
}
