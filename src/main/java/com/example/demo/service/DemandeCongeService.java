package com.example.demo.service;

import com.example.demo.bean.Collaborateur;
import com.example.demo.bean.DemandeConge;
import com.example.demo.dao.DemandeCongeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private CollaborateurService collaborateurService;
 private DemandeCongeDao getDemandeCongeDao;
    public Optional<DemandeConge> findById(Long id) {
        return demandeCongeDao.findById(id);
    }

    public List<DemandeConge> findAll() {
        return demandeCongeDao.findAll();
    }


    public int save(DemandeConge demandeConge){
        if(demandeCongeDao.findByCode(demandeConge.getCode())!=null){
            return  -3;
        }else{
            Collaborateur collaborateur= collaborateurService.findByCodeCollaborateur(demandeConge.getCollaborateur().getCodeCollaborateur());
            if( collaborateur == null){
                return -1;
            }else{
                demandeConge.setCollaborateur(collaborateur);
                demandeCongeDao.save(demandeConge);
                return 1;
            }
        }
    }
    public int update(String code,DemandeConge demandeConge){
        DemandeConge demandeConge1= demandeCongeDao.findByCode(code);
        if(demandeConge1!=null){
            demandeConge1.setEtatDemandeConge(demandeConge.getEtatDemandeConge());
            Collaborateur collaborateur=collaborateurService.findByCodeCollaborateur(demandeConge.getCollaborateur().getCodeCollaborateur());
            demandeConge1.setCollaborateur(collaborateur);
            demandeConge1.setCode(demandeConge.getCode());
            demandeConge1.setDateDepart(demandeConge.getDateDepart());
            demandeConge1.setDateFin(demandeConge.getDateFin());
            demandeConge1.setMessageCollaborateur(demandeConge.getMessageCollaborateur());
            demandeCongeDao.save(demandeConge1);
            return 1;
        }
        else{
            return -1;
        }

    }
    @Transactional
    public int deleteByCode(String code) {
        return demandeCongeDao.deleteByCode(code);
    }

    public DemandeConge findByCode(String code) {
        return demandeCongeDao.findByCode(code);
    }

    public List<DemandeConge> findByCollaborateur(String collaborateur) {
        return demandeCongeDao.findByCollaborateurCodeCollaborateur(collaborateur);
    }
}
