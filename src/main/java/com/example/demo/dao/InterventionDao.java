package com.example.demo.dao;

import com.example.demo.bean.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterventionDao extends JpaRepository<Intervention,Long> {
    Intervention findByCode(String code);
    List<Intervention> findByDateDeProbleme(String dateDeProbleme);
    List<Intervention> findByDateDebutAndDateFin(String dateDebut,String DateFin);
    List<Intervention> findByEtatIntervention(String etatIntervention);
    List<Intervention> findAll();
    List<Intervention> findByInterventionMembreEquipeEquipeRef(String ref);
    List<Intervention> findByInterventionMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(String code);
    int deleteByCode(String code);
    int deleteByEtatIntervention(String etatIntervention);
}
