package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes_empresas")
public class CustomerCompany {
    @Id
    @Column(name = "id_persona")
    private Long id;
    @Column(name = "cuit" )
    private String cuit;
    @Column(name = "razon_social")
    private String businessName;
    @OneToOne
    @MapsId("customerParticular")
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Customer customer;

    @jakarta.persistence.PrePersist
    private void PrePersist(){
        if (this.id == null) {
            this.id = customer.getId();
        }
    }
}
