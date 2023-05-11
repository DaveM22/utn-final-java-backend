package com.example.utnfinaljava.entities;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Customer {
    @Id
    @Column(name="id_persona")
    private Long id;

    @Column(name = "id_tipo_cliente")
    private Long typeCustomerId;

    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    private Persona persona;

    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable =  false)
    private CustomerParticular particular;

    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable =  false)
    @NotFound(action = NotFoundAction.IGNORE)
    private CustomerCompany company;
}
