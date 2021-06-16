package com.example.demo.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    public List<MembreEquipe> getMembres() {
        return membres;
    }

    public void setMembres(List<MembreEquipe> membres) {
        this.membres = membres;
    }

    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    @OneToMany(mappedBy = "equipe")
    private List<MembreEquipe> membres;
    private String libelle;
    private String code;
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
