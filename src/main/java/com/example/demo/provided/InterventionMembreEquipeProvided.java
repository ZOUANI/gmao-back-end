package com.example.demo.provided;

import com.example.demo.bean.Intervention;
import com.example.demo.bean.InterventionMembreEquipe;
import com.example.demo.service.InterventionMembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Collaborateurintervention-api/Collaborateurintervention")
public class InterventionMembreEquipeProvided {
    @Autowired
    InterventionMembreEquipeService interventionMembreEquipeService;
    @GetMapping("CollaborateurCode/{codeCollaborateur}/InterventionCode/{codeIntervention}")
    public InterventionMembreEquipe findinterventionMembreEquipeParCodeColANDCodeInter(String codeCollaborateur, String codeIntervention) {
        return interventionMembreEquipeService.findByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }

    @DeleteMapping("CollaborateurCode/{codeCollaborateur}/InterventionCode/{codeIntervention}")
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(String codeCollaborateur, String codeIntervention) {
        return interventionMembreEquipeService.deleteByMembreEquipeCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }

    @PostMapping("/")
    public int save(@RequestBody InterventionMembreEquipe interventionCollaborateur, Intervention intervention) {
        return interventionMembreEquipeService.save(interventionCollaborateur,intervention);
    }
}