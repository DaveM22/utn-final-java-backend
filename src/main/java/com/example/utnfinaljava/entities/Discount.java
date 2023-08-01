package com.example.utnfinaljava.entities;

import com.example.utnfinaljava.entities.claves_compuestas.DiscountId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "descuento_ventas")
public class Discount implements Comparable<Discount> {
    @EmbeddedId
    private DiscountId id;
    @Column(name = "porc_descuento")
    private float discount;
    
    @Override
    public int compareTo(Discount o) {
        return o.id.getValidityDate().compareTo(this.id.getValidityDate());
    }
}
