package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes_particulares")
public class CustomerParticular {
    @Id
    @Column(name = "id_persona")
    private Long id;
    @Column(name = "nombre" )
    private String firstName;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "dni")
    private String dni;
}
