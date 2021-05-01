package com.example.demo.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private String adresse;
    @OneToMany
    private List<Stock> stocks;
    @OneToOne
    private TypeMagasin typemagasin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public TypeMagasin getTypemagasin() {
        return typemagasin;
    }

    public void setTypemagasin(TypeMagasin typemagasin) {
        this.typemagasin = typemagasin;
    }
}
