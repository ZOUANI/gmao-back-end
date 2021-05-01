package com.example.demo.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateDeProbleme;
    private Date dateDebut;
    private Date dateFin;
    private String description;
    private String libelle;
    @ManyToOne
    private EtatIntervention etatIntervention;

    @OneToOne
    private InterventionCollaborateur interventionCollaborateur;

    @OneToMany
    private List<MateraialIntervention> materaialInterventions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return dateDeProbleme;
    }

    public void setDate(Date dateDeProbleme) {
        this.dateDeProbleme = dateDeProbleme;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public InterventionCollaborateur getCollaborateurs() {
        return interventionCollaborateur;
    }

    public void setCollaborateurs(InterventionCollaborateur interventionCollaborateur) {
        this.interventionCollaborateur = interventionCollaborateur;
    }

    public EtatIntervention getEtatIntervention() {
        return etatIntervention;
    }

    public void setEtatIntervention(EtatIntervention etatIntervention) {
        this.etatIntervention = etatIntervention;
    }

    public List<MateraialIntervention> getMateraialInterventions() {
        return materaialInterventions;
    }

    public void setMateraialInterventions(List<MateraialIntervention> materaialInterventions) {
        this.materaialInterventions = materaialInterventions;
    }
}
