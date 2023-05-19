package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes_particulares")
public class CustomerParticular {
    @Id
    @Column(name = "id_persona")
    private Long id;
    @Column(name = "nombre" )
    private String firstName;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "dni")
    private String dni;
    @OneToOne
    @MapsId("customerParticular")
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Customer customer;

    @PrePersist
    private void PrePersist(){
        if (this.id == null) {
            this.id = customer.getId();
        }
    }
}
