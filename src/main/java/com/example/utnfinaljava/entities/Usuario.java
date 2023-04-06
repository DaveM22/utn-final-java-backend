package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "nombre")
    public String nombre;
    @Column(name = "apellido")
    public String apellido;
    @Column(name = "email")
    public String email;
    @Column(name = "clave")
    public String clave;
}
