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
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion_email")
    private String email;
    @Column(name = "pagina_web")
    private String paginaWeb;
    @Column(name = "cod_postal")
    private Long postalCode;
    @OneToOne
    @JoinColumn(name = "cod_postal", referencedColumnName = "cod_postal", insertable = false, updatable = false)
    private Location localidad;
}
