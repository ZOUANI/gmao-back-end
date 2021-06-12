package com.example.demo.provided;

import com.example.demo.bean.TacheIntervention;
import com.example.demo.service.TacheInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/tacheIntervention")
public class TacheInterventionProvided {

    @Autowired
    private TacheInterventionService tacheInterventionService;

    @GetMapping("/collaborateur/{codeCollaborateur}/intervention/{codeIntervention}")
    public List<TacheIntervention> findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(@PathVariable String codeCollaborateur,@PathVariable String codeIntervention) {
        return tacheInterventionService.findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }

    @GetMapping("/code/{code}")
    public int completerTache(@PathVariable String code) {
        return tacheInterventionService.completerTache(code);
    }

    @PostMapping("/")
    public int save(@RequestBody TacheIntervention tacheIntervention) {
        return tacheInterventionService.save(tacheIntervention);
    }

    @GetMapping("/code/{Code}")
    public TacheIntervention findByCode(@PathVariable String code) {
        return tacheInterventionService.findByCode(code);
    }

    @GetMapping("/")
    public List<TacheIntervention> findAll() {
        return tacheInterventionService.findAll();
    }


}
