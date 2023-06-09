package com.example.utnfinaljava.entities.claves_compuestas;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ProductoProveedorId implements Serializable {
 
    @Column(name = "id_producto")
    public Long productId;

    @Column(name = "id_persona")
    private Long personaId;

}
