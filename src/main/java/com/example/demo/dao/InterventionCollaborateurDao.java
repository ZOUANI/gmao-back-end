package com.example.demo.dao;

import com.example.demo.bean.InterventionCollaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventionCollaborateurDao  extends JpaRepository<InterventionCollaborateur,Long> {
    InterventionCollaborateur findByCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur,String codeIntervention);
    int deleteByCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur,String codeIntervention);
}
