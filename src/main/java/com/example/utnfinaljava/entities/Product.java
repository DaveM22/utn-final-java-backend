package com.example.utnfinaljava.entities;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.websocket.OnOpen;
import lombok.Data;

@Data
@Entity
@Table(name="productos")
public class Product {
    
    @Id
    @Column(name ="id_producto")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Category categoria;

    @JsonManagedReference
    @OneToMany(mappedBy = "id.producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSupplier> proveedores = new ArrayList<>();

    public Long GetTotal(){
        return this.proveedores.stream().mapToLong(o -> o.getCantidad()).sum();
    }

}
