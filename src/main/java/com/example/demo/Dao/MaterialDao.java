package com.example.demo.Dao;

import com.example.demo.bean.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialDao extends JpaRepository<Material,Long> {
    List<Material> findByTypeMaterialCode(String type);
//    List<Material> findByLibelle(String Libelle);
//    Material findByLibelleAndTypeMaterialCode(String Libelle,String type);
    Material findByReference(String refMaterial);
    List <Material> findAll();
    List<Material> findByCategoryMaterialCode(String code);
    int deleteByReference(String refMaterial);
    int deleteByLibelle(String Libelle);
}
