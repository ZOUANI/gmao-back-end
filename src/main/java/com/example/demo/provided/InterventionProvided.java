package com.example.demo.provided;

import com.example.demo.bean.Intervention;
import com.example.demo.service.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Intervention-api/intervention")
public class InterventionProvided {
    @Autowired
    private InterventionService interventionService;
    @GetMapping("findCode/{code}")
    public Intervention findByCode(@PathVariable String code) {
        return interventionService.findByCode(code);
    }
    @GetMapping("dateProbleme/{dateDeProbleme}")
    public List<Intervention> findByDateDeProbleme(@PathVariable String dateDeProbleme) {
        return interventionService.findByDateDeProbleme(dateDeProbleme);
    }
    @GetMapping("datedebut/{dateDebut}/datefin/{DateFin}")
    public List<Intervention> findByDateDebutAndDateFin(@PathVariable String dateDebut,@PathVariable String DateFin) {
        return interventionService.findByDateDebutAndDateFin(dateDebut, DateFin);
    }
    @GetMapping("Etatintervention/{etatIntervention}")
    public List<Intervention> findByEtatIntervention(@PathVariable String etatIntervention) {
        return interventionService.findByEtatIntervention(etatIntervention);
    }
    @GetMapping("/")
    public List<Intervention> findAll() {
        return interventionService.findAll();
    }

    @DeleteMapping("deleteCode/{code}")
    public int deleteByCode(@PathVariable String code) {
        return interventionService.deleteByCode(code);
    }

    @DeleteMapping("Etatintervention/{etatIntervention}")
    public int deleteByEtatIntervention(@PathVariable String etatIntervention) {
        return interventionService.deleteByEtatIntervention(etatIntervention);
    }
    @PostMapping("/")
    public int save(@RequestBody Intervention intervention) {
        return interventionService.save(intervention);
    }
}
