package com.example.demo.service;

import com.example.demo.bean.Equipe;
import com.example.demo.bean.Intervention;
import com.example.demo.bean.InterventionMembreEquipe;
import com.example.demo.bean.MembreEquipe;
import com.example.demo.dao.InterventionMembreEquipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterventionMembreEquipeService {
    public InterventionMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateur(String code) {
        return interventionCollaborateurDao.findByMembreEquipeCollaborateurCodeCollaborateur(code);
    }

    @Autowired
    private InterventionMembreEquipeDao interventionCollaborateurDao;
    @Autowired
    private MembreEquipeService membreEquipeService;
    @Autowired
    private EquipeService equipeService;
    public InterventionMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur, String codeIntervention) {
        return interventionCollaborateurDao.findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }
    @Transactional
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur, String codeIntervention) {
        return interventionCollaborateurDao.deleteByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }
    @Transactional
    public int deleteByInterventionCode(String code) {
        return interventionCollaborateurDao.deleteByInterventionCode(code);
    }

    public int save(InterventionMembreEquipe interventionMembreEquipe, Intervention intervention){
//        interventionCollaborateur.setIntervention(intervention);
        Equipe equipe=equipeService.findByRef(interventionMembreEquipe.getEquipe().getRef());
        MembreEquipe membreEquipe=membreEquipeService.findByCollaborateurCodeCollaborateur(interventionMembreEquipe.getMembreEquipe().getCollaborateur().getCodeCollaborateur());
        if (membreEquipe==null || equipe ==null)
            return -2;
        InterventionMembreEquipe interventionMembreEquip =new InterventionMembreEquipe();
        interventionMembreEquip.setEquipe(equipe);
        interventionMembreEquip.setIntervention(intervention);
        interventionMembreEquip.setMembreEquipe(membreEquipe);
        interventionCollaborateurDao.save(interventionMembreEquip);
        return 1;
    }

    public List<InterventionMembreEquipe> findByInterventionCode(String code) {
        return interventionCollaborateurDao.findByInterventionCode(code);
    }
    @Transactional
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRef(String code, String ref, String interv) {
        return interventionCollaborateurDao.deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRefAndInterventionCode(code, ref,interv);
    }
}
