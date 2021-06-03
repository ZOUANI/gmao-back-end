package com.example.demo.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "equipe")
    private List<MembreEquipe> membreEquipe;
    private String libelle;
    private String code;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    private MembreEquipe chefEquipe;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public MembreEquipe getChefEquipe() {
        return chefEquipe;
    }

    public void setChefEquipe(MembreEquipe chefEquipe) {
        this.chefEquipe = chefEquipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MembreEquipe> getMembreEquipe() {
        return membreEquipe;
    }

    public void setMembreEquipe(List<MembreEquipe> membreEquipe) {
        this.membreEquipe = membreEquipe;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
