package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class InterventionMembreEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private MembreEquipe membreEquipe;
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Intervention intervention;
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Equipe equipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MembreEquipe getMembreEquipe() {
        return membreEquipe;
    }

    public void setMembreEquipe(MembreEquipe collaborateur) {
        this.membreEquipe = collaborateur;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
