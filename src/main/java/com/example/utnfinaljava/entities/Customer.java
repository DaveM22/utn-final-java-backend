package com.example.utnfinaljava.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Customer {
    @Id
    @Column(name="id_persona")
    private Long id;
    
    @OneToOne
    @MapsId("customer")
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    @PrePersist
    private void PrePersist(){
        if (this.id == null) {
            this.id = persona.getId();
        }
    }
}
