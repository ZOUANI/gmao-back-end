package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
@Entity
public class TacheIntervention {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String code;
    private String description;
   // private String EtatTache;
    private Date date;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private MembreEquipe membreEquipe;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Intervention intervention;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private EtatTache etatTache;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EtatTache getEtatTache() {
        return etatTache;
    }

    public void setEtatTache(com.example.demo.bean.EtatTache etatTache) {
        this.etatTache = etatTache;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MembreEquipe getMembreEquipe() {
        return membreEquipe;
    }

    public void setMembreEquipe(MembreEquipe membreEquipe) {
        this.membreEquipe = membreEquipe;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }
}
