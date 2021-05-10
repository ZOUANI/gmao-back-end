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
	    @JsonFormat(pattern = "dd-MM-YYYY")
	    private Date dateDeProbleme;
	    @JsonFormat(pattern = "dd-MM-YYYY")
	    private Date dateDebut;
	    @JsonFormat(pattern = "dd-MM-YYYY")
	    private Date dateFin;
	    private String description;
	    private String libelle;
	    private String code;
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
}
