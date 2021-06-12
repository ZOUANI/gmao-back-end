package com.example.demo.dao;

import com.example.demo.bean.TacheIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TacheInterventionDao extends JpaRepository<TacheIntervention,Long> {
    public int deleteByCode(String code);
    public  TacheIntervention findByCode(String code);
    public List<TacheIntervention>  findByMembreEquipeCollaborateurCodeCollaborateur(String codeCollaborateur);
    public List<TacheIntervention>  findByInterventionCode(String code);
    public List<TacheIntervention>  findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur, String codeIntervention);
}
