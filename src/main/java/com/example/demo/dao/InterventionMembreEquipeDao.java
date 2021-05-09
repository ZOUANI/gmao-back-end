package com.example.demo.dao;

import com.example.demo.bean.InterventionMembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventionMembreEquipeDao  extends JpaRepository<InterventionMembreEquipe,Long> {
    InterventionMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur, String codeIntervention);
    int deleteByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur,String codeIntervention);
}