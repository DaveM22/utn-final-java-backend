package com.example.utnfinaljava.entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.example.utnfinaljava.entities.claves_compuestas.ProductoProveedorId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos_proveedores")
public class ProductSupplier {

    @JsonIgnore()
    @EmbeddedId
    private ProductoProveedorId id;

    @Column(name = "cantidad")
    private Long cantidad;

    @JsonIgnoreProperties("proveedores")
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    private Product producto;
    
    @ManyToOne
    @JoinColumn(name = "cuit", referencedColumnName = "cuit", insertable = false, updatable = false)
    private Persona proveedor;
    
    @OneToMany
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto"),
        @JoinColumn(name = "cuit", referencedColumnName = "cuit")
    })
    private List<Price> prices = new ArrayList<>();


    public Price getValidityPrice(){
        LocalDate currentDate = LocalDate.now();
        Price vigentPrice = null;
        List<Price> pricesReversed = this.prices;
        Collections.sort(pricesReversed, Collections.reverseOrder());
        for (Price price : pricesReversed ) {
            LocalDate fromDate = price.getId().getDateFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (fromDate.isBefore(currentDate) || fromDate.equals(currentDate)) {    
                    vigentPrice = price;
            }
        }
    
        return vigentPrice;
    }
}
