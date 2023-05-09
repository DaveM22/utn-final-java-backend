package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario_roles")
public class UserRole {
    @Id
    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "id_rol")
    private Long rolId;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private User user;


    @OneToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
    private Role role;
}
