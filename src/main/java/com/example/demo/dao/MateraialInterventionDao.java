package com.example.demo.dao;

import com.example.demo.bean.InterventionMembreEquipe;
import com.example.demo.bean.MateraialIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateraialInterventionDao extends JpaRepository<MateraialIntervention,Long> {
    MateraialIntervention findByMaterialReferenceAndInterventionCode(String reference,String code);
    int deleteByMaterialReferenceAndInterventionCode(String reference,String code);
    List<MateraialIntervention> findByInterventionCodeAndCollaborateurCodeCollaborateur(String codeIterv, String codeColab);
    List<MateraialIntervention> findByInterventionCode(String code);
    int deleteByMaterialReferenceAndMagasinReferenceAndInterventionCode(String reference,String ref,String code);

}
