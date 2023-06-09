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
@Table(name = "proveedores")
public class Supplier {
    @Id
    @Column(name = "id_persona")
    private Long id;

    @OneToOne
    @MapsId("supplier")
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = true, updatable =  true)
    private Persona persona;

    @Column(name="cuit")
    private String cuit;
    
    @Column(name = "razon_social")
    private String businessName;

    @jakarta.persistence.PrePersist
    private void PrePersist(){
        if (this.id == null) {
            this.id = persona.getId();
        }
    }
}
