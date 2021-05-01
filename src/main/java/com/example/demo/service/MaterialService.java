package com.example.demo.service;

import com.example.demo.dao.MaterialDao;
import com.example.demo.bean.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private MaterialDao materialDao;

    public List<Material> findByType(String type) {
        return materialDao.findByTypeMaterialCode(type);
    }

    public Material findByReference(String refMaterial) {
        return materialDao.findByReference(refMaterial);
    }


    public List<Material> findAll() {
        return materialDao.findAll();
    }

    public List<Material> findByCategoryMaterialCode(String code) {
        return materialDao.findByCategoryMaterialCode(code);
    }

    @Transactional
    public int deleteByReference(String refMaterial) {
        return materialDao.deleteByReference(refMaterial);
    }
    @Transactional
    public int deleteByLibelle(String Libelle) {
        return materialDao.deleteByLibelle(Libelle);
    }
}
