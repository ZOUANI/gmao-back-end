package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Collaborateur;
import com.example.demo.bean.Conseils;
import com.example.demo.bean.Intervention;
import com.example.demo.dao.ConseilsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConseilsService {
    @Autowired
    private ConseilsDao conseilsDao;
    @Autowired
    private CollaborateurService collaborateurService;

    public List<Conseils> findByCollaborateurCodeCollaborateur(String code) {
        return conseilsDao.findByCollaborateurCodeCollaborateur(code);
    }

    public List<Conseils> findByInterventionCode(String code) {
        return conseilsDao.findByInterventionCode(code);
    }
    // public List<Consigne> findByEquipeRef(String ref) {
    // return conseilsDao.findByEquipeRef(ref);
    // }

    // public List<Consigne> findByEquipeRefAndCollaborateurcodeCollaborateur(String
    // ref, String code) {
    // return conseilsDao.findByEquipeRefAndCollaborateurCodeCollaborateur(ref,
    // code);
    // }
    @Transactional
    public void deleteById(Long id) {
        conseilsDao.deleteById(id);
    }

    @Transactional
    public int deleteByCollaborateurCodeCollaborateur(String code, String message, String interv) {
        return conseilsDao.deleteByCollaborateurCodeCollaborateurAndMessageAndInterventionCode(code, message, interv);
    }

    public List<Conseils> findAll() {
        return conseilsDao.findAll();
    }
    @Transactional
    public int deleteByInterventionCode(String code) {
        return conseilsDao.deleteByInterventionCode(code);
    }

    public int save(Intervention intervention, Conseils conseils) {
        Collaborateur collaborateur = collaborateurService
                .findByCodeCollaborateur(conseils.getCollaborateur().getCodeCollaborateur());
        if (collaborateur == null) {
            return -2;
        } else {
            Conseils conseil = new Conseils();
            conseil.setCollaborateur(collaborateur);
            conseil.setMessage(conseils.getMessage());
            conseil.setIntervention(intervention);
            conseilsDao.save(conseil);
            return 1;
        }

    }
}
