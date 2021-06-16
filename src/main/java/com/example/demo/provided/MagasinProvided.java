package com.example.demo.provided;

import java.util.List;

import com.example.demo.bean.Magasin;
import com.example.demo.service.MagasinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("GMAO/Magasin-api")
public class MagasinProvided {
    @Autowired
    private MagasinService magasinService;

    @GetMapping("adresse/{adresse}")
    public List<Magasin> findByAdresse(@PathVariable String adresse) {
        return magasinService.findByAdresse(adresse);
    }

    @GetMapping("reference/{Ref}")
    public Magasin findByReference(@PathVariable String Ref) {
        return magasinService.findByReference(Ref);
    }

    @GetMapping("cle/{motcle}")
    public List<Magasin> chercherMagasinparAdresse(@PathVariable String motcle) {
        return magasinService.chercherMagasinparAdresse(motcle);
    }

    @GetMapping("code/{Code}")
    public Magasin findByTypeMagasinCode(@PathVariable String Code) {
        return magasinService.findByTypeMagasinCode(Code);
    }

    @GetMapping("/")
    public List<Magasin> findAll() {
        return magasinService.findAll();
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByReference(@PathVariable String ref) {
        return magasinService.deleteByReference(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody Magasin magasin) {
        return magasinService.save(magasin);
    }
}
