/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.bean.Collaborateur;
import com.example.demo.bean.Equipe;
import com.example.demo.bean.MembreEquipe;
import com.example.demo.dao.MembreEquipeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mehdi
 */
@Service
public class MembreEquipeService {

    @Autowired
    private MembreEquipeDao membreEquipeDao;
    @Autowired
    private CollaborateurService collaborateurService;

    public MembreEquipe findByCollaborateurFullname(String fullname) {
        return membreEquipeDao.findByCollaborateurFullname(fullname);
    }

    public MembreEquipe findByEquipeRef(String ref) {
        return membreEquipeDao.findByEquipeRef(ref);
    }

    @Transactional
    public int deleteByCollaborateurFullname(String fullname) {
        return membreEquipeDao.deleteByCollaborateurFullname(fullname);
    }

    public List<MembreEquipe> findAll() {
        return membreEquipeDao.findAll();
    }

    public int save(Equipe equipe, List<MembreEquipe> membreEquipes) {

        for (MembreEquipe membre : membreEquipes) {

            if (membre.getCollaborateur() != null && membre.getCollaborateur().getCodeCollaborateur() != null) {
                Collaborateur collaborateur = collaborateurService
                        .findByCodeCollaborateur(membre.getCollaborateur().getCodeCollaborateur());
                membre.setCollaborateur(collaborateur);
                membre.setEquipe(equipe);
                membreEquipeDao.save(membre);
            }
        }
        return 0;
    }
}
