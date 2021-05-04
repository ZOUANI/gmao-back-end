package com.example.demo.service;

import com.example.demo.bean.Collaborateur;
import com.example.demo.bean.Conseils;
import com.example.demo.bean.Equipe;
import com.example.demo.dao.ConseilsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ConseilsService {
    @Autowired
    private ConseilsDao conseilsDao;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private EquipeService equipeService;
    public List<Conseils> findByCollaborateurCodeCollaborateur(String code) {
        return conseilsDao.findByCollaborateurCodeCollaborateur(code);
    }

    public List<Conseils> findByEquipeRef(String ref) {
        return conseilsDao.findByEquipeRef(ref);
    }

    public List<Conseils> findByDateDeMessage(Date date) {
        return conseilsDao.findByDateDeMessage(date);
    }

    public List<Conseils> findByEquipeRefAndCollaborateurcodeCollaborateur(String ref, String code) {
        return conseilsDao.findByEquipeRefAndCollaborateurCodeCollaborateur(ref, code);
    }
    @Transactional
    public void deleteById(Long id) {
        conseilsDao.deleteById(id);
    }
    @Transactional
    public int deleteByDateDeMessage(Date date) {
        return conseilsDao.deleteByDateDeMessage(date);
    }
    @Transactional
    public int deleteByCollaborateurCodeCollaborateur(String code) {
        return conseilsDao.deleteByCollaborateurCodeCollaborateur(code);
    }

    public List<Conseils> findAll() {
        return conseilsDao.findAll();
    }
    public int save(Conseils conseils){
        Collaborateur collaborateur=collaborateurService.findByCodeCollaborateur(conseils.getCollaborateur().getCodeCollaborateur());
        Equipe equipe=equipeService.findByRef(conseils.getEquipe().getRef());
        if(collaborateur==null || equipe==null){
            return -2;
        }
        else
        {
            Conseils conseil=new Conseils();
            conseil.setCollaborateur(collaborateur);
            conseil.setDateDeMessage(conseils.getDateDeMessage());
            conseil.setEquipe(equipe);
            conseil.setMessage(conseils.getMessage());
            conseilsDao.save(conseil);
            return 1;
        }

    }
}
