package com.example.utnfinaljava.entities;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.websocket.OnOpen;
import lombok.Data;

@Data
@Entity
@Table(name="productos")
public class Product {
    
    @Id
    @Column(name ="id_producto")
    private Long id;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "id_categoria")
    private Long categoryId;

    @OneToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", insertable = false, updatable = false)
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "id.producto", cascade = CascadeType.ALL)
    private List<ProductSupplier> suppliers = new ArrayList<>();

    public Long GetTotal(){
        return this.suppliers.stream().mapToLong(o -> o.getAmount()).sum();
    }

}
