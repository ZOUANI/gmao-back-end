package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @OneToOne
    private TypeMaterial typeMaterial;
    private String libelle;
    @ManyToOne
    private CategoryMaterial categoryMaterial ;

    public CategoryMaterial getCategoryMaterial() {
        return categoryMaterial;
    }

    public void setCategoryMaterial(CategoryMaterial categoryMaterial) {
        this.categoryMaterial = categoryMaterial;
    }

    public TypeMaterial getType() {
        return typeMaterial;
    }

    public void setType(TypeMaterial type) {
        this.typeMaterial = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

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
}
