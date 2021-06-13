package com.example.demo.provided;

import com.example.demo.bean.Intervention;
import com.example.demo.bean.InterventionMembreEquipe;
import com.example.demo.service.InterventionMembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Collaborateurintervention-api/Collaborateurintervention")
public class InterventionMembreEquipeProvided {
    @GetMapping("/code/{code}")
    public InterventionMembreEquipe findByMembreEquipeCollaborateurCodeCollaborateur(@PathVariable String code) {
        return interventionMembreEquipeService.findByMembreEquipeCollaborateurCodeCollaborateur(code);
    }

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
    public int save(@RequestBody InterventionMembreEquipe interventionCollaborateur,@RequestBody Intervention intervention) {
        return interventionMembreEquipeService.save(interventionCollaborateur,intervention);
    }

    @GetMapping("/intervcode/{code}")
    public List<InterventionMembreEquipe> findByInterventionCode(@PathVariable String code) {
        return interventionMembreEquipeService.findByInterventionCode(code);
    }

    @DeleteMapping("CollaborateurCod/{code}/Equipe/{ref}/interv/{interv}")
    public int deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRef(@PathVariable String code,@PathVariable String ref,@PathVariable String interv) {
        return interventionMembreEquipeService.deleteByMembreEquipeCollaborateurCodeCollaborateurAndEquipeRef(code, ref,interv);
    }
}
