package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Intervention {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonFormat(pattern = "dd-MM-YYYY")
    private Date dateDeProbleme;
    @JsonFormat(pattern = "dd-MM-YYYY")
    private Date dateDebut;
    @JsonFormat(pattern = "dd-MM-YYYY")
    private Date dateFin;
    private String description;
    private String libelle;
    private String code;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private EtatIntervention etatIntervention;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "intervention")
    private List<InterventionCollaborateur> interventionCollaborateur;

    @OneToMany(mappedBy = "intervention" )
    private List<MateraialIntervention> materaialInterventions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDeProbleme() {
        return dateDeProbleme;
    }

    public void setDateDeProbleme(Date dateDeProbleme) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EtatIntervention getEtatIntervention() {
        return etatIntervention;
    }

    public void setEtatIntervention(EtatIntervention etatIntervention) {
        this.etatIntervention = etatIntervention;
    }

    public List<InterventionCollaborateur> getInterventionCollaborateur() {
        return interventionCollaborateur;
    }

    public void setInterventionCollaborateur(List<InterventionCollaborateur> interventionCollaborateur) {
        this.interventionCollaborateur = interventionCollaborateur;
    }

    public List<MateraialIntervention> getMateraialInterventions() {
        return materaialInterventions;
    }

    public void setMateraialInterventions(List<MateraialIntervention> materaialInterventions) {
        this.materaialInterventions = materaialInterventions;
    }
}
