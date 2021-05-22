package com.example.demo.provided;

import com.example.demo.bean.Intervention;
import com.example.demo.service.InterventionService;
import com.example.demo.vo.InterventionVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("Gmao/intervention")
public class InterventionProvided {
    @Autowired
    private InterventionService interventionService;
    @GetMapping("/Code/{code}")
    public Intervention findByCode(@PathVariable String code) {
        return interventionService.findByCode(code);
    }
    @PostMapping("/criteria")
    public List<Intervention> findByCriteria(@RequestBody InterventionVo interventionVo){
    return  interventionService.findByCriteria(interventionVo);
    }
    @GetMapping("/dateProbleme/{dateDeProbleme}")
    public List<Intervention> findByDateDeProbleme(@PathVariable String dateDeProbleme) {
        return interventionService.findByDateDeProbleme(dateDeProbleme);
    }
    @GetMapping("/datedebut/{dateDebut}/datefin/{DateFin}")
    public List<Intervention> findByDateDebutAndDateFin(@PathVariable String dateDebut,@PathVariable String DateFin) {
        return interventionService.findByDateDebutAndDateFin(dateDebut, DateFin);
    }
    @GetMapping("/Etatintervention/{etatIntervention}")
    public List<Intervention> findByEtatIntervention(@PathVariable String etatIntervention) {
        return interventionService.findByEtatIntervention(etatIntervention);
    }
    @GetMapping("/")
    public List<Intervention> findAll() {
        return interventionService.findAll();
    }

    @DeleteMapping("/Code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return interventionService.deleteByCode(code);
    }

    @DeleteMapping("/Etatintervention/{etatIntervention}")
    public int deleteByEtatIntervention(@PathVariable String etatIntervention) {
        return interventionService.deleteByEtatIntervention(etatIntervention);
    }
    @PostMapping("/")
    public int save(@RequestBody Intervention intervention) throws ParseException {
        return interventionService.save(intervention);
    }
    @PutMapping("/code/{code}")
    public int update(@PathVariable String code,@RequestBody Intervention intervention) {
        return interventionService.update(code, intervention);
    }
    @GetMapping("/equiperef/{ref}")
    public List<Intervention> findByEquipeRef(@PathVariable String ref) {
        return interventionService.findByEquipeRef(ref);
    }
    @GetMapping("/codeCollan/{code}")
    public List<Intervention> findByCodeCollaborateur(@PathVariable String code) {
        return interventionService.findByCodeCollaborateur(code);
    }
}
