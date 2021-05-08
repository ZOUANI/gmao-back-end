package com.example.demo.service;

import com.example.demo.bean.Collaborateur;
import com.example.demo.bean.Consigne;
import com.example.demo.bean.Equipe;
import com.example.demo.bean.Intervention;
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
    public List<Consigne> findByCollaborateurCodeCollaborateur(String code) {
        return conseilsDao.findByCollaborateurCodeCollaborateur(code);
    }

//    public List<Consigne> findByEquipeRef(String ref) {
//        return conseilsDao.findByEquipeRef(ref);
//    }

    public List<Consigne> findByDateDeMessage(Date date) {
        return conseilsDao.findByDateDeMessage(date);
    }
//
//    public List<Consigne> findByEquipeRefAndCollaborateurcodeCollaborateur(String ref, String code) {
//        return conseilsDao.findByEquipeRefAndCollaborateurCodeCollaborateur(ref, code);
//    }
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

    public List<Consigne> findAll() {
        return conseilsDao.findAll();
    }

    public int save(Intervention intervention, Consigne conseils){
        Collaborateur collaborateur=collaborateurService.findByCodeCollaborateur(conseils.getCollaborateur().getCodeCollaborateur());
//        Equipe equipe=equipeService.findByRef(conseils.etEquipe().getRef());
//        DateTimeFormatter localdate = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
        if(collaborateur==null ){
//            || equipe==null)
            return -2;
        }
        else
        {
            Consigne conseil=new Consigne();
            conseil.setCollaborateur(collaborateur);
            conseil.setDateDeMessage(conseils.getDateDeMessage());
//            conseil.setEquipe(equipe);
            conseil.setMessage(conseils.getMessage());
            conseil.setIntervention(intervention);
            conseilsDao.save(conseil);
            return 1;
        }

    }
}
