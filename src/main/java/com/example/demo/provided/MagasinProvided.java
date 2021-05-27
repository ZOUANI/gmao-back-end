package com.example.demo.provided;

import com.example.demo.bean.Magasin;
import com.example.demo.bean.Material;
import com.example.demo.service.MagasinService;
import com.example.demo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("GMAO/Magasin")
public class MagasinProvided {
    @Autowired
    private MagasinService magasinService;
    @GetMapping("adresse/{adresse}")
    public List<Magasin> findByAdresse(String adresse) {
        return magasinService.findByAdresse(adresse);
    }
    @GetMapping("reference/{Ref}")
    public Magasin findByReference(String Ref) {
        return magasinService.findByReference(Ref);
    }
    @GetMapping("cle/{motcle}")
    public List<Magasin> chercherMagasinparAdresse(String motcle) {
        return magasinService.chercherMagasinparAdresse(motcle);
    }
    @GetMapping("code/{Code}")
    public Magasin findByTypeMagasinCode(String Code) {
        return magasinService.findByTypeMagasinCode(Code);
    }
    @GetMapping("/")
    public List<Magasin> findAll() {
        return magasinService.findAll();
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByReference(String ref) {
        return magasinService.deleteByReference(ref);
    }
}
