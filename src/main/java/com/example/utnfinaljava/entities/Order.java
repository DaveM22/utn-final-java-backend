package com.example.utnfinaljava.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_pedido")
    private Long orderNumber;
    @Column(name = "fecha_pedido")
    private Date orderDate;
    @Column(name = "id_persona")
    private Long personaId;
    @OneToOne()
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    public Supplier supplier;


    @OneToMany()
    @JoinColumn(name = "nro_pedido", referencedColumnName = "nro_pedido")
    private List<OrderDetail> details = new ArrayList<>();
    

    public Long GetTotalAmount(){
        if(details.size() == 0){
            return null;
        }
        return this.details.stream().mapToLong(o -> o.getAmount()).sum();
    }
}
