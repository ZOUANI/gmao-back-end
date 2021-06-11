package com.example.demo.service;

import com.example.demo.bean.*;
import com.example.demo.dao.MateraialInterventionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MateraialInterventionService {
    @Autowired
    private MateraialInterventionDao materaialInterventionDao;
    @Autowired
    private MagasinService magasinService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private CollaborateurService collaborateurService;
    public MateraialIntervention findByMaterialReferenceAndInterventionCode(String reference, String code) {
        return materaialInterventionDao.findByMaterialReferenceAndInterventionCode(reference, code);
    }
    @Transactional
    public int deleteByMaterialReferenceAndInterventionCode(String reference, String code) {
        return materaialInterventionDao.deleteByMaterialReferenceAndInterventionCode(reference, code);
    }
    @Transactional
    public int deleteByMaterialReferenceAndMagasinReference(String reference, String ref, String code) {
        return materaialInterventionDao.deleteByMaterialReferenceAndMagasinReferenceAndInterventionCode(reference, ref,code);
    }

    public List<MateraialIntervention> findByInterventionCode(String code) {
        return materaialInterventionDao.findByInterventionCode(code);
    }

    public int save(MateraialIntervention materaialIntervention){
//        materaialIntervention.setIntervention(intervention);
        Magasin magasin=magasinService.findByReference(materaialIntervention.getMagasin().getReference());
        if(magasin ==null)
            return -2;
        Material material = materialService.findByReference(materaialIntervention.getMaterial().getReference());
        if (material==null)
            return -2;
        Collaborateur collaborateur=collaborateurService.findByCodeCollaborateur(materaialIntervention.getCollaborateur().getCodeCollaborateur());
        if (collaborateur ==null)
            return -2;
        materaialIntervention.setMaterial(material);
        materaialIntervention.setMagasin(magasin);
        materaialIntervention.setCollaborateur(collaborateur);
        materaialInterventionDao.save(materaialIntervention);
        return 1;
    }

    public List<MateraialIntervention> findByInterventionCodeAndCollaborateurCode(String codeIterv, String codeColab) {
        return materaialInterventionDao.findByInterventionCodeAndCollaborateurCodeCollaborateur(codeIterv, codeColab);
    }
}
