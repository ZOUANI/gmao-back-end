package com.example.demo.bean;

import javax.persistence.*;

@Entity
public class InterventionCollaborateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Collaborateur collaborateur;
    @OneToOne
    private Intervention intervention;
    @ManyToOne
    private EtatIntervention etatIntervention;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public EtatIntervention getEtatIntervention() {
        return etatIntervention;
    }

    public void setEtatIntervention(EtatIntervention etatIntervention) {
        this.etatIntervention = etatIntervention;
    }
}
