package com.example.utnfinaljava.entities.claves_compuestas;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PreciosId {
    @Column(name="id_producto")
    public Long productoId;
    @Column(name="cuit")
    public String cuit;
    @Column(name="fecha_desde")
    public Date dateFrom;
}
