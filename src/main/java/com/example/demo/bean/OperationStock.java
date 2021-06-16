package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OperationStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Material material;
    private double qte;
    @ManyToOne
    private Magasin magasinSource;
    @ManyToOne
    private Magasin magasinDestination;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getQte() {
        return qte;
    }

    public void setQte(double qte) {
        this.qte = qte;
    }

    public Magasin getMagasinSource() {
        return magasinSource;
    }

    public void setMagasinSource(Magasin magasinSource) {
        this.magasinSource = magasinSource;
    }

    public Magasin getMagasinDestination() {
        return magasinDestination;
    }

    public void setMagasinDestination(Magasin magasinDestination) {
        this.magasinDestination = magasinDestination;
    }
}
