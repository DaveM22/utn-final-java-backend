package com.example.utnfinaljava.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "nro_pedido")
    private Long orderNumber;
    @Column(name = "fecha_pedido")
    private Date orderDate;
    @OneToOne()
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    public Supplier supplier;
    @OneToMany(mappedBy = "id.orderNumber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> details = new ArrayList<>();
    

    public Long GetTotalAmount(){
        if(details.size() == 0){
            return null;
        }
        return this.details.stream().mapToLong(o -> o.getAmount()).sum();
    }
}
