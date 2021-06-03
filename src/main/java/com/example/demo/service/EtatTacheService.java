package com.example.demo.service;

import com.example.demo.bean.EtatTache;
import com.example.demo.bean.TacheIntervention;
import com.example.demo.dao.EtatTacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtatTacheService {
    public void update(EtatTache etatTache){
        etatTacheDao.save(etatTache);
    }
      public int save(EtatTache etatTache) {
          if (findByDescription(etatTache.getDescription()) != null)
              return -1;
          else if (findByCode(etatTache.getCode()) != null)
              return -2;
          else if (findByLibelle(etatTache.getLibelle()) != null)
              return -3;
          else {
              etatTacheDao.save(etatTache);
              return 1;
          }
      }

    public EtatTache findByCode(String code) {
        return etatTacheDao.findByCode(code);
    }

    public EtatTache findByLibelle(String libelle) {
        return etatTacheDao.findByLibelle(libelle);
    }

    public EtatTache findByDescription(String description) {
        return etatTacheDao.findByDescription(description);
    }

    public List<EtatTache> findAll() {
        return etatTacheDao.findAll();
    }

    @Transactional
    public int deleteByCode(String code) {
        List<TacheIntervention> resultTacheIntervention = TacheInterventionService.deleteByEtatTacheCode(code);
        int resultEtatTache = etatTacheDao.deleteByCode(code);
        return resultEtatTache;

    }

    @Autowired
    private EtatTacheDao etatTacheDao;

    @Autowired
    private TacheInterventionService tacheInterventionService;
}
