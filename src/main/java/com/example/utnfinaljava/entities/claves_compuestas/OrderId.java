package com.example.utnfinaljava.entities.claves_compuestas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class OrderId {
    @Column(name = "nro_pedido")
    private Long orderNumber;
    @Column(name = "id_producto")
    private Long productId;
    @Column(name = "cuit")
    private String cuit;
}
