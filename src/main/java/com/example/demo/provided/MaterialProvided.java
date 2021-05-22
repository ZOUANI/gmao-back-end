package com.example.demo.provided;

import com.example.demo.bean.Material;
import com.example.demo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Gmao/Material")
public class MaterialProvided {
    @Autowired
    private MaterialService materialService;
    @GetMapping("Type/{type}")
    public List<Material> findByType(String type) {
        return materialService.findByType(type);
    }
    @GetMapping("ref/{refMaterial}")
    public Material findByReference(String refMaterial) {
        return materialService.findByReference(refMaterial);
    }
    @GetMapping("/")
    public List<Material> findAll() {
        return materialService.findAll();
    }
    @GetMapping("category/{code}")
    public List<Material> findByCategoryMaterialCode(String code) {
        return materialService.findByCategoryMaterialCode(code);
    }

    @DeleteMapping("refmat/{refMaterial}")
    public int deleteByReference(String refMaterial) {
        return materialService.deleteByReference(refMaterial);
    }

    @DeleteMapping("Libelle/{Libelle}")
    public int deleteByLibelle(String Libelle) {
        return materialService.deleteByLibelle(Libelle);
    }
}
