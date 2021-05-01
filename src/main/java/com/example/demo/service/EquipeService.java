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

/**
 *
 * @author mehdi
 */
@Service
public class EquipeService {

    @Autowired
    private EquipeDao equipeDao;

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
//    A Completer
    public int save(Equipe equipe) {
        return 0;
    }

}
