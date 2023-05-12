package com.example.utnfinaljava.entities.claves_compuestas;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DiscountId {
    @Column(name = "fecha_vigencia")
    private Date validityDate;
    @Column(name = "monto_desde")
    private float amountPrice;
}
