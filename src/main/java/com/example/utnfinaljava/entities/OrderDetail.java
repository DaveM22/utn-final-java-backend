package com.example.utnfinaljava.entities;

import com.example.utnfinaljava.entities.claves_compuestas.OrderId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @Column(name="precio")
    private Float price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable =  false)
    private Product product;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable =  false)
    private Supplier supplier;
}
