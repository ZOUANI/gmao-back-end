package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
@Entity
public class TacheIntervention {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String code;
    private String description;
    private Boolean etatTache;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private MembreEquipe membreEquipe;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Intervention intervention;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getEtatTache() {
        return etatTache;
    }

    public void setEtatTache(Boolean etatTache) {
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
