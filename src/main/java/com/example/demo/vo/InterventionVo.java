package com.example.demo.vo;
import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.bean.Conseils;
import com.example.demo.bean.EtatIntervention;
//import com.example.demo.bean.InterventionCollaborateur;
import com.example.demo.bean.MateraialIntervention;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InterventionVo {
	 private Long id;
	    private String dateDeProbleme;
	    private String dateDebut;
	    private String dateFin;
	    private String description;
	    private String libelle;
	    private String code;
	    private String couleur;

		public String getCouleur() {
			return couleur;
		}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDateDeProbleme() {
			return dateDeProbleme;
		}
		public void setDateDeProbleme(String dateDeProbleme) {
			this.dateDeProbleme = dateDeProbleme;
		}
		public String getDateDebut() {
			return dateDebut;
		}
		public void setDateDebut(String dateDebut) {
			this.dateDebut = dateDebut;
		}
		public String getDateFin() {
			return dateFin;
		}
		public void setDateFin(String dateFin) {
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
}
