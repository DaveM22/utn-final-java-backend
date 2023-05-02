package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_cliente")
public class CustomerType {
    @Id
    @Column(name = "id_tipo_cliente")
    private Long id;
    @Column(name = "descripcion")
    private String description;
}
