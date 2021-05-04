package com.example.demo.service;

import com.example.demo.bean.Collaborateur;
import com.example.demo.bean.InterventionCollaborateur;
import com.example.demo.dao.InterventionCollaborateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InterventionCollaborateurService {
    @Autowired
    private InterventionCollaborateurDao interventionCollaborateurDao;
    @Autowired
    private CollaborateurService collaborateurService;
    public InterventionCollaborateur findByCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur, String codeIntervention) {
        return interventionCollaborateurDao.findByCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }
    @Transactional
    public int deleteByCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur, String codeIntervention) {
        return interventionCollaborateurDao.deleteByCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }
    public int save(InterventionCollaborateur interventionCollaborateur){
//        interventionCollaborateur.setIntervention(intervention);
        Collaborateur collaborateur=collaborateurService.findByCodeCollaborateur(interventionCollaborateur.getCollaborateur().getCodeCollaborateur());
        if (collaborateur==null)
            return -2;
        InterventionCollaborateur interventionCollaborateur1 =new InterventionCollaborateur();
        interventionCollaborateur1.setCollaborateur(collaborateur);
        interventionCollaborateur1.setIntervention(interventionCollaborateur.getIntervention());
        interventionCollaborateurDao.save(interventionCollaborateur1);
        return 1;
    }
}
