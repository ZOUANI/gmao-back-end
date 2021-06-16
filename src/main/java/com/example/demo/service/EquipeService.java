/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.Equipe;
import com.example.demo.bean.MembreEquipe;
import com.example.demo.dao.EquipeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipeService {

    @Autowired
    private EquipeDao equipeDao;

    public List<Equipe> findAll() {
        return equipeDao.findAll();
    }

    @Autowired
    private MembreEquipeService membreEquipeService;

    @Transactional
    public int deleteByRef(String ref) {
        return equipeDao.deleteByRef(ref);
    }

    public Equipe findByLibelle(String libelle) {
        return equipeDao.findByLibelle(libelle);
    }

    public Equipe findByChefEquipeCollaborateurCode(String code) {
        return equipeDao.findByChefEquipeCollaborateurCodeCollaborateur(code);
    }

    public Equipe findByCode(String code) {
        return equipeDao.findByCode(code);
    }

    public Equipe findByRef(String ref) {
        return equipeDao.findByRef(ref);
    }

    public int save(Equipe equipe) {
        if (equipeDao.findByRef(equipe.getRef()) != null)
            return -1;
        else {
            membreEquipeService.save(equipe.getChefEquipe());
            equipe.getChefEquipe().setEquipe(equipe);
            equipeDao.save(equipe);
            for (MembreEquipe membreEquipe : equipe.getMembres()) {
                membreEquipe.setEquipe(equipe);
                if (equipe.getChefEquipe().getCollaborateur().getCodeCollaborateur()
                        .equals(membreEquipe.getCollaborateur().getCodeCollaborateur()))
                    continue;
                membreEquipeService.save(membreEquipe);
            }
        }

        return 0;
    }

    public int update(String ref, Equipe equipe) {
        Equipe equipe1 = findByRef(ref);
        if (equipe1 != null) {
            equipe1.setRef(equipe.getRef());
            equipe1.setLibelle(equipe.getLibelle());
            equipe1.setCode(equipe.getCode());
            MembreEquipe chefEquipe = membreEquipeService.findByCollaborateurCodeCollaborateur(
                    equipe.getChefEquipe().getCollaborateur().getCodeCollaborateur());
            if (chefEquipe == null) {
                membreEquipeService.save(equipe.getChefEquipe());
            }
            equipe.getChefEquipe().setEquipe(equipe1);
            equipe1.setChefEquipe(equipe.getChefEquipe());
            List<MembreEquipe> membreEquipeList = new ArrayList<>();
            equipeDao.save(equipe1);
            for (MembreEquipe membres : equipe.getMembres()) {
                MembreEquipe membreEquipe = membreEquipeService
                        .findByCollaborateurCodeCollaborateur(membres.getCollaborateur().getCodeCollaborateur());
                membres.setEquipe(equipe1);
                if (equipe.getChefEquipe().getCollaborateur().getCodeCollaborateur()
                        .equals(membreEquipe.getCollaborateur().getCodeCollaborateur()))
                    continue;
                membreEquipeService.save(membres);
                membreEquipeList.add(membreEquipe);
            }
            equipe1.setMembres(membreEquipeList);

            return 1;
        } else {
            return -2;
        }
    }
}
