package com.example.utnfinaljava.entities;

import com.example.utnfinaljava.entities.claves_compuestas.PriceId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "precios")
public class Price implements Comparable<Price> {
    @JsonIgnore()
    @EmbeddedId
    private PriceId id;

    @Column(name="precio")
    private Float price;

    @Override
    public int compareTo(Price arg0) {
        return arg0.id.getDateFrom().compareTo(this.id.dateFrom);
    }


}
