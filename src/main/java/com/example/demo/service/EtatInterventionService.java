package com.example.demo.service;

import com.example.demo.bean.EtatIntervention;
import com.example.demo.dao.EtatInterventionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtatInterventionService {
    @Autowired
    private EtatInterventionDao etatInterventionDao;

    public EtatIntervention findByCode(String code) {
        return etatInterventionDao.findByCode(code);
    }

    public List<EtatIntervention> findByCouleurIntervention(String couleurIntervention) {
        return etatInterventionDao.findByCouleur(couleurIntervention);
    }
    @Transactional
    public int deleteByCode(String code) {
        return etatInterventionDao.deleteByCode(code);
    }

}
