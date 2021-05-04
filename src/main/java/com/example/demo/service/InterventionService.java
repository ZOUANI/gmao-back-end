package com.example.demo.service;

import com.example.demo.bean.*;
import com.example.demo.dao.InterventionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterventionService {
    @Autowired
    private InterventionDao interventionDao;
    @Autowired
    private EtatInterventionService etatInterventionService;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private InterventionCollaborateurService interventionCollaborateurService;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private MateraialInterventionService materaialInterventionService;

    public Intervention findByCode(String code) {
        return interventionDao.findByCode(code);
    }

    public List<Intervention> findByDateDeProbleme(String dateDeProbleme) {
        return interventionDao.findByDateDeProbleme(dateDeProbleme);
    }

    public List<Intervention> findByDateDebutAndDateFin(String dateDebut, String DateFin) {
        return interventionDao.findByDateDebutAndDateFin(dateDebut, DateFin);
    }

    public List<Intervention> findByEtatIntervention(String etatIntervention) {
        return interventionDao.findByEtatIntervention(etatIntervention);
    }

    public List<Intervention> findAll() {
        return interventionDao.findAll();
    }

    @Transactional
    public int deleteByCode(String code) {
        return interventionDao.deleteByCode(code);
    }

    @Transactional
    public int deleteByEtatIntervention(String etatIntervention) {
        return interventionDao.deleteByEtatIntervention(etatIntervention);
    }

    public int save(Intervention intervention) {
        EtatIntervention etatIntervention = etatInterventionService.findByCode(intervention.getEtatIntervention().getCode());
        if(etatIntervention==null)
            return -2;

        if (findByCode(intervention.getCode())!=null) {
            intervention.setEtatIntervention(etatIntervention);
            interventionDao.save(intervention);
            int b = 2, a = 2;
            for (MateraialIntervention materaialIntervention : intervention.getMateraialInterventions()) {
                materaialIntervention.setIntervention(intervention);
                b = materaialInterventionService.save(materaialIntervention);
            }
            for (InterventionCollaborateur interventionCollaborateur : intervention.getInterventionCollaborateur()) {
                interventionCollaborateur.setIntervention(intervention);
                a = interventionCollaborateurService.save(interventionCollaborateur);
            }

            return a + b;
        }
        else
            return -3;
    }
//        EtatIntervention etatIntervention=etatInterventionService.findByCode(intervention.getEtatIntervention().getCode());
//        intervention.setEtatIntervention(etatIntervention);
//        interventionDao.save(intervention);
//        for (MateraialIntervention materaialIntervention : intervention.getMateraialInterventions()) {
//            materaialInterventionService.save(intervention, materaialIntervention);
//        }
//        for (InterventionCollaborateur interventionCollaborateur : intervention.getInterventionCollaborateur()) {
//
//            interventionCollaborateurService.save(intervention,interventionCollaborateur);
//        }
//        return 1;
//    }
}
