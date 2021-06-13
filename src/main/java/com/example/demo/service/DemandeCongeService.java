package com.example.demo.service;

import com.example.demo.bean.Collaborateur;
import com.example.demo.bean.DemandeConge;
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
    private CollaborateurService collaborateurService;



    @Autowired
    private DemandeCongeDao getDemandeCoxngeDao;

    public Optional<DemandeConge> findById(Long id) {
        return demandeCongeDao.findById(id);
    }

    public List<DemandeConge> findAll() {
        return demandeCongeDao.findAll();
    }

    public DemandeConge findByCode(String code) {
        return demandeCongeDao.findByCode(code);
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
}
