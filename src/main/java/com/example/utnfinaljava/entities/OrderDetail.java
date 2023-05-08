package com.example.utnfinaljava.entities;

import com.example.utnfinaljava.entities.claves_compuestas.OrderId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos_detalles")
public class OrderDetail {
    @EmbeddedId
    private OrderId id;

    @Column(name="cantidad")
    private int amount;

    @Column(name="total")
    private Long total;
}
