/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.bean.Equipe;
import com.example.demo.dao.EquipeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipeService {

    @Autowired
    private EquipeDao equipeDao;
    @Autowired
    private MembreEquipeService membreEquipeService;

    @Transactional
    public int deleteByRef(String ref) {
        return equipeDao.deleteByRef(ref);
    }

    public Equipe findByLibelle(String libelle) {
        return equipeDao.findByLibelle(libelle);
    }

    public Equipe findByChefEquipeCollaborateurFullname(String fullname) {
        return equipeDao.findByChefEquipeCollaborateurFullname(fullname);
    }

    public Equipe findByCode(String code) {
        return equipeDao.findByCode(code);
    }

    public Equipe findByRef(String ref) {
        return equipeDao.findByRef(ref);
    }

    public List<Equipe> findAll() {
        return equipeDao.findAll();
    }

    public int save(Equipe equipe) {
        if (equipeDao.findByRef(equipe.getRef()) != null)
            return -1;
        else {
            equipe.setChefEquipe(equipe.getChefEquipe());
            equipeDao.save(equipe);
            membreEquipeService.save(equipe, equipe.getMembreEquipe());
            return 0;
        }
    }
}
