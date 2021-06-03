package com.example.demo.provided;

import com.example.demo.bean.EtatTache;
import com.example.demo.service.EtatTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="code/etatTache")
public class EtatTacheProvided {

    @PutMapping("/")
    public void update(@RequestBody EtatTache etatTache) {
        etatTacheService.update(etatTache);
    }

    @PostMapping("/")
    public int save(@RequestBody EtatTache etatTache) {
        return etatTacheService.save(etatTache);
    }

    @GetMapping("/code/{code}")
    public EtatTache findByCode(String code) {
        return etatTacheService.findByCode(code);
    }

    @GetMapping("/libelle/{libelle}")
    public EtatTache findByLibelle(String libelle) {
        return etatTacheService.findByLibelle(libelle);
    }

    @GetMapping("/description/{description}")
    public EtatTache findByDescription(@PathVariable String description) {
        return etatTacheService.findByDescription(description);
    }

    @GetMapping("/")
    public List<EtatTache> findAll() {
        return etatTacheService.findAll();
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return etatTacheService.deleteByCode(code);
    }

    @Autowired
    private EtatTacheService etatTacheService;
}
