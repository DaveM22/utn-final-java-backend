package com.example.utnfinaljava.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    @Column(name = "descuento")
    private Float discount;
    
    @OneToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable=false, updatable=false)
    public CustomerCompany company;

    @OneToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable=false, updatable=false)
    public CustomerParticular particular;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "nro_pedido", referencedColumnName = "nro_pedido")
    private List<OrderDetail> details = new ArrayList<>();
    
    public Long GetTotalAmount(){
        if(details.size() == 0){
            return null;
        }
        return this.details.stream().mapToLong(o -> o.getAmount()).sum();
    }
}
