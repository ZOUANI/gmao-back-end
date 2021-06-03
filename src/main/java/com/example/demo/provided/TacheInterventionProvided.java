package com.example.demo.provided;

import com.example.demo.bean.TacheIntervention;
import com.example.demo.service.TacheInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="code/tacheIntervention")
public class TacheInterventionProvided {

    @PostMapping("/")
    public int save(@RequestBody TacheIntervention tacheIntervention) {
        return tacheInterventionService.save(tacheIntervention);
    }

    @GetMapping("/code/{Code}")
    public TacheIntervention findByCode(@PathVariable String code) {
        return tacheInterventionService.findByCode(code);
    }
    @GetMapping("/EtatTache/code/{Code}")
    public List<TacheIntervention> findByEtatTacheCode(@PathVariable String code) {
        return tacheInterventionService.findByEtatTacheCode(code);
    }

    @DeleteMapping("/code/{code}")
    public static List<TacheIntervention> deleteByEtatTacheCode(@PathVariable String code) {
        return TacheInterventionService.deleteByEtatTacheCode(code);
    }

    @GetMapping("/")
    public List<TacheIntervention> findAll() {
        return tacheInterventionService.findAll();
    }

    @Autowired
    private TacheInterventionService tacheInterventionService;
}
