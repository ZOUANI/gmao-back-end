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
    @Autowired
    private ConseilsService conseilsService;

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
    public int update(String code,Intervention intervention){
        Intervention interventions=findByCode(code);
        if (interventions!=null){
            if(intervention.getEtatIntervention()!=null)
                 interventions.setEtatIntervention(intervention.getEtatIntervention());
            if (intervention.getInterventionCollaborateur()!=null)
                interventions.setInterventionCollaborateur(intervention.getInterventionCollaborateur());
            if (intervention.getMateraialInterventions()!=null)
                interventions.setMateraialInterventions(intervention.getMateraialInterventions());
            interventions.setCode(intervention.getCode());
            if (intervention.getConseils()!=null)
                interventions.setConseils(intervention.getConseils());
            interventions.setDateDebut(intervention.getDateDebut());
            interventions.setDateDeProbleme(intervention.getDateDeProbleme());
            interventions.setDateFin(intervention.getDateFin());
            interventions.setDescription(intervention.getDescription());
            interventions.setLibelle(intervention.getLibelle());
            interventionDao.save(interventions);
            return  1;
        }
        else
            return -2;
    }
    public int save(Intervention intervention) {
        EtatIntervention etatIntervention = etatInterventionService.findByCode(intervention.getEtatIntervention().getCode());
        if(etatIntervention==null)
            return -2;

        if (findByCode(intervention.getCode())==null) {
            intervention.setEtatIntervention(etatIntervention);
            interventionDao.save(intervention);
            int b = 2, a = 2,c=2;
            for (MateraialIntervention materaialIntervention : intervention.getMateraialInterventions()) {
                materaialIntervention.setIntervention(intervention);
                b = materaialInterventionService.save(materaialIntervention);
            }
            for (InterventionCollaborateur interventionCollaborateur : intervention.getInterventionCollaborateur()) {
                interventionCollaborateur.setIntervention(intervention);
                a = interventionCollaborateurService.save(interventionCollaborateur);
            }
            for(Conseils conseils : intervention.getConseils()){
                c=conseilsService.save(intervention,conseils);
            }

            return a + b + c;
        }
        else
            return -1;
    }


}
