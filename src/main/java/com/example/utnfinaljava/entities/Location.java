package com.example.utnfinaljava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "localidades")
public class Location {
    @Id
    @Column(name = "cod_postal")
    private Long postalCode;

    @Column(name = "ciudad")
    private String city;

    @Column(name = "cod_provincia")
    private Long codProvince;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_provincia", referencedColumnName = "cod_provincia", insertable = false, updatable = false)
    private Province province;

    public String GetMilanesas(){
        return "asd";
    }
}
