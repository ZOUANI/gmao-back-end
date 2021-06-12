package com.example.demo.service;

import com.example.demo.bean.Collaborateur;
import com.example.demo.bean.DemandeConge;
import com.example.demo.bean.EtatDemandeConge;
import com.example.demo.dao.DemandeCongeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeCongeService {
    @Autowired
    private EntityManager entityManager;

 @Autowired
 private DemandeCongeDao demandeCongeDao;
    @Autowired
    private EtatDemandeCongeService etatDemandeCongeService;
    @Autowired
    private CollaborateurService collaborateurService;
 private DemandeCongeDao getDemandeCongeDao;
    public Optional<DemandeConge> findById(Long id) {
        return demandeCongeDao.findById(id);
    }

    public List<DemandeConge> findByEtatDemandeCongeCode(String code) {
        return demandeCongeDao.findByEtatDemandeCongeCode(code);
    }

    public List<DemandeConge> findAll() {
        return demandeCongeDao.findAll();
    }


    public int save(DemandeConge demandeConge){
        if(demandeCongeDao.findByCode(demandeConge.getCode())!=null){
            return  -3;
        }else{
            EtatDemandeConge etatDemandeConge = etatDemandeCongeService.findByCode(demandeConge.getEtatDemandeConge().getCode());
            Collaborateur collaborateur= collaborateurService.findByCodeCollaborateur(demandeConge.getCollaborateur());
            if(etatDemandeConge == null || collaborateur == null){
                return -1;
            }else{
//                demandeConge.setCollaborateur(collaborateur);
                demandeConge.setEtatDemandeConge(etatDemandeConge);
                demandeCongeDao.save(demandeConge);
                return 1;
            }
        }
    }
}
