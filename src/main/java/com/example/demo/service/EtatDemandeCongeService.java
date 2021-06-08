package com.example.demo.service;

import com.example.demo.bean.EtatDemandeConge;
import com.example.demo.dao.EtatDemandeCongeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatDemandeCongeService {
    @Autowired
    private EtatDemandeCongeDao etatDemandeCongeDao;

    public EtatDemandeConge findByCode(String code) {
        return etatDemandeCongeDao.findByCode(code);
    }

    public List<EtatDemandeConge> findAll() {
        return etatDemandeCongeDao.findAll();
    }



}
