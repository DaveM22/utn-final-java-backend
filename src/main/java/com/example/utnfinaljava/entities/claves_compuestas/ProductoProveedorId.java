package com.example.utnfinaljava.entities.claves_compuestas;


import java.io.Serializable;

import com.example.utnfinaljava.entities.Persona;
import com.example.utnfinaljava.entities.Producto;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
public class ProductoProveedorId implements Serializable {
 
    @Column(name = "id_producto")
    public Long producto;

    @Column(name = "cuit")
    private String cuit;

}
