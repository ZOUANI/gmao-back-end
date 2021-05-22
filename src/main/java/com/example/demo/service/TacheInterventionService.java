package com.example.demo.service;

import com.example.demo.bean.EtatTache;
import com.example.demo.bean.TacheIntervention;
import com.example.demo.dao.TacheInterventionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheInterventionService {

    private static TacheInterventionService tacheInterventionDao;

    public int save(TacheIntervention tacheIntervention) {
        if (findByCode(tacheIntervention.getCode()) != null)
            return -1;
        else {

            EtatTache etatTache = null;
            etatTacheService.update(etatTache);
          //  TacheIntervention tacheIntervention = null;
            tacheInterventionDao.save(tacheIntervention);
            return 1;
        }
    }
    public TacheIntervention findByCode(String code) {
        return tacheInterventionDao.findByCode(code);
    }

    public List<TacheIntervention> findByEtatTacheCode(String code) {
        return tacheInterventionDao.findByEtatTacheCode(code);
    }

    public static List<TacheIntervention> deleteByEtatTacheCode(String code) {
        return tacheInterventionDao.deleteByEtatTacheCode(code);
    }

    public List<TacheIntervention> findAll() {
        return tacheInterventionDao.findAll();
    }
  //  @Autowired
  //  private TacheInterventionDao tacheInterventionDao;

    @Autowired
    private EtatTacheService etatTacheService;
}
