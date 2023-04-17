package com.example.utnfinaljava.entities;

import com.example.utnfinaljava.entities.claves_compuestas.ProductoProveedorId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos_proveedores")
public class ProductoProveedor {

    @JsonIgnore()
    @EmbeddedId
    private ProductoProveedorId id;

    @Column(name = "cantidad")
    private Long cantidad;

    @JsonIgnoreProperties("proveedores")
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "cuit", referencedColumnName = "cuit", insertable = false, updatable = false)
    private Persona proveedor;
}
