package com.example.demo.service;

import com.example.demo.bean.*;
import com.example.demo.dao.InterventionMembreEquipeDao;
import com.example.demo.dao.MembreEquipeDao;
import com.example.demo.dao.TacheInterventionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheInterventionService {

    @Autowired
    private TacheInterventionDao tacheInterventionDao;
    @Autowired
    private InterventionService interventionService;
    @Autowired
    private InterventionMembreEquipeDao interventionMembreEquipeDao;

    @Autowired
    private MembreEquipeDao membreEquipeDao;

    public int deleteByCode(String code) {
        return tacheInterventionDao.deleteByCode(code);
    }

    public TacheIntervention findByCode(String code) {
        return tacheInterventionDao.findByCode(code);
    }

    public List<TacheIntervention> findByMembreEquipeCollaborateurCodeCollaborateur(String codeCollaborateur) {
        return tacheInterventionDao.findByMembreEquipeCollaborateurCodeCollaborateur(codeCollaborateur);
    }

    public List<TacheIntervention> findByInterventionCode(String code) {
        return tacheInterventionDao.findByInterventionCode(code);
    }

    public List<TacheIntervention> findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur, String codeIntervention) {
        return tacheInterventionDao.findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }

    public List<TacheIntervention> findAll() {
        return tacheInterventionDao.findAll();
    }

//    public boolean verifierAppartenance(String codeIntervention,String codeMembre){
//        InterventionMembreEquipe x =
//
//        return x == null;
//
//    }

    public int save( TacheIntervention tacheIntervention) {
        MembreEquipe membreEquipe = membreEquipeDao.findByCollaborateurCodeCollaborateur(
                tacheIntervention
                        .getMembreEquipe()
                        .getCollaborateur()
                        .getCodeCollaborateur()
        );
        Intervention intervention = interventionService.findByCode(
                tacheIntervention
                        .getIntervention()
                        .getCode()
        );
//        System.out.println(intervention.getCode()+"             "+membreEquipe.getId());
        if(intervention == null || membreEquipe == null){
            return -1;
        }
//        InterventionMembreEquipe interventionMembreEquipe=interventionMembreEquipeDao.findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(tacheIntervention.getIntervention().getCode(), tacheIntervention.getMembreEquipe().getCollaborateur().getCodeCollaborateur());
//        if(interventionMembreEquipe == null)
//            return -2;
        else{
            try{
                tacheIntervention.setIntervention(intervention);
                tacheIntervention.setEtatTache(false);
                tacheIntervention.setMembreEquipe(membreEquipe);
                tacheInterventionDao.save(tacheIntervention);
                return 1;
            }catch(Exception e){
                return -3;
            }
        }
    }
    public int completerTache(String codeTache){
        TacheIntervention tacheIntervention = tacheInterventionDao.findByCode(codeTache);
            try{
                tacheIntervention.setEtatTache(true);
                tacheInterventionDao.save(tacheIntervention);
                return 1;
            }
            catch(Exception e){
                return -3;
            }

    }


}
