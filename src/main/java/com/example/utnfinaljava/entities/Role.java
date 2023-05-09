package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id_rol")
    public Long idRole;
    @Column(name = "rol_nombre")
    public String roleName;


}
