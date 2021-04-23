package com.example.demo.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<MembreEquipe> membreEquipe;
    private String libelle;
    private String code;

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
