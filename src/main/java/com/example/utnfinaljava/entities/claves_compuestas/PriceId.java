package com.example.utnfinaljava.entities.claves_compuestas;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PriceId {
    @Column(name="id_producto")
    public Long productId;
    @Column(name="id_persona")
    public Long personaId;
    @Column(name="fecha_desde")
    public Date dateFrom;
}
