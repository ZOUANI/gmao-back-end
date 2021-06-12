/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author MoulaYounes
 */
@Entity
public class DemandeConge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    @ManyToOne
    private Collaborateur collaborateur;
    private String action;
    private String dateDepart;
    private String dateFin;
    private String messageCollaborateur;
    //    private String commentaireValidateur;
    @ManyToOne
    private EtatDemandeConge etatDemandeConge;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getMessageCollaborateur() {
        return messageCollaborateur;
    }

    public void setMessageCollaborateur(String messageCollaborateur) {
        this.messageCollaborateur = messageCollaborateur;
    }

    public EtatDemandeConge getEtatDemandeConge() {
        return etatDemandeConge;
    }

    public void setEtatDemandeConge(EtatDemandeConge etatDemandeConge) {
        this.etatDemandeConge = etatDemandeConge;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


}



