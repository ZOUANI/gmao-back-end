package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.bean.*;
import com.example.demo.dao.InterventionDao;
import com.example.demo.service.util.StringUtil;
import com.example.demo.vo.InterventionVo;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InterventionService {
    @Autowired
    private InterventionDao interventionDao;
    @Autowired
    private EtatInterventionService etatInterventionService;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private InterventionMembreEquipeService interventionMembreEquipeService;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private MateraialInterventionService materaialInterventionService;
    @Autowired
    private ConseilsService conseilsService;
    // @Autowired
    // private InterventionVo interventionVo;
    @Autowired
    private EntityManager entityManager;

    public Intervention findByCode(String code) {
        return interventionDao.findByCode(code);
    }

    public List<Intervention> findByDateDeProbleme(String dateDeProbleme) {
        return interventionDao.findByDateDeProbleme(dateDeProbleme);
    }

    public List<Intervention> findByEquipeRef(String ref) {
        return interventionDao.findByInterventionMembreEquipeEquipeRef(ref);
    }

    public List<Intervention> findByCodeCollaborateur(String code) {
        return interventionDao.findByInterventionMembreEquipeMembreEquipeCollaborateurCodeCollaborateur(code);
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

    public List<Intervention> findByCriteria(InterventionVo interventionVo) {
        String query = "SELECT o FROM Intervention o WHERE 1=1 ";
        if (StringUtil.isNotEmpty(interventionVo.getCode()))
            query += " AND o.code LIKE '%" + interventionVo.getCode() + "%'";
        if (interventionVo.getDateDeProbleme() != null)
            query += " AND o.dateDeProbleme LIKE '%" + interventionVo.getDateDeProbleme() + "%'";
        if (interventionVo.getDateDebut() != null)
            query += " AND o.dateDebut LIKE '%" + interventionVo.getDateDebut() + "%'";
        if (interventionVo.getDateFin() != null)
            query += " AND o.dateFin LIKE '%" + interventionVo.getDateFin() + "%'";
        if (StringUtil.isNotEmpty(interventionVo.getDescription()))
            query += " AND o.description '%" + interventionVo.getDescription() + "%'";
        if (StringUtil.isNotEmpty(interventionVo.getLibelle()))
            query += " AND o.libelle  LIKE  '%" + interventionVo.getLibelle() + "%'";
        if (StringUtil.isNotEmpty(interventionVo.getCouleur()))
            query += " AND o.etatIntervention.couleur  LIKE  '%" + interventionVo.getCouleur() + "%'";

        return entityManager.createQuery(query).getResultList();
    }

    public List<Intervention> findByMonth(String month) {
        String query = "SELECT o FROM Intervention o WHERE month(dateDebut) = " + month + " and month(dateFin) = "
                + month;
        return entityManager.createQuery(query).getResultList();

    }

    @Transactional
    public int deleteByCode(String code) {
        return interventionDao.deleteByCode(code);
    }

    @Transactional
    public int deleteByEtatIntervention(String etatIntervention) {
        return interventionDao.deleteByEtatIntervention(etatIntervention);
    }

    public int update(String code, Intervention intervention) {
        Intervention interventions = findByCode(code);
        interventionMembreEquipeService.deleteByInterventionCode(code);
        if (interventions != null) {
            EtatIntervention etatIntervention= etatInterventionService.findByCode(intervention.getEtatIntervention().getCode());
            interventions.setEtatIntervention(etatIntervention);
            if(intervention.getInterventionMembreEquipe()!=null) {
                for (InterventionMembreEquipe membreEquipe : intervention.getInterventionMembreEquipe()) {
                    if(interventionMembreEquipeService.findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(membreEquipe.getMembreEquipe().getCollaborateur().getCodeCollaborateur(),code)==null) {
                        interventionMembreEquipeService.save(membreEquipe, intervention);
                    }
                }
            }
            if(intervention.getMateraialInterventions()!=null){
            for (MateraialIntervention materaialIntervention : intervention.getMateraialInterventions()) {
                materaialIntervention.setIntervention(intervention);
                materaialInterventionService.save(materaialIntervention);
            }}
            interventions.setMateraialInterventions(intervention.getMateraialInterventions());
            interventions.setCode(intervention.getCode());
            if(intervention.getConseils()!=null)
            {
                conseilsService.deleteByInterventionCode(code);
                for (Conseils conseils : intervention.getConseils()) {
                 conseilsService.save(intervention, conseils);
            }}
            interventions.setConseils(intervention.getConseils());
            interventions.setDateDebut(intervention.getDateDebut());
            interventions.setDateDeProbleme(intervention.getDateDeProbleme());
            interventions.setDateFin(intervention.getDateFin());
            interventions.setDescription(intervention.getDescription());
            interventions.setLibelle(intervention.getLibelle());
            interventionDao.save(interventions);
            return 1;
        } else
            return -2;
    }

    public int save(Intervention intervention) {
        EtatIntervention etatIntervention = etatInterventionService
                .findByCode(intervention.getEtatIntervention().getCode());
        if (etatIntervention == null)
            return -2;

        if (findByCode(intervention.getCode()) == null) {
            intervention.setEtatIntervention(etatIntervention);
            interventionDao.save(intervention);
            int b = 2, a = 2, c = 2;
            for (MateraialIntervention materaialIntervention : intervention.getMateraialInterventions()) {
                materaialIntervention.setIntervention(intervention);
                b = materaialInterventionService.save(materaialIntervention);
            }
            for (InterventionMembreEquipe interventionCollaborateur : intervention.getInterventionMembreEquipe()) {
                a = interventionMembreEquipeService.save(interventionCollaborateur, intervention);
            }
            for (Conseils conseils : intervention.getConseils()) {
                c = conseilsService.save(intervention, conseils);
            }

            return a + b + c;
        } else
            return -1;
    }

}
