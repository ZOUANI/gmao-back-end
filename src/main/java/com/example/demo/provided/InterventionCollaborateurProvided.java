package com.example.demo.provided;

import com.example.demo.bean.Intervention;
import com.example.demo.bean.InterventionCollaborateur;
import com.example.demo.service.InterventionCollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Collaborateurintervention-api/Collaborateurintervention")
public class InterventionCollaborateurProvided {
    @Autowired
    InterventionCollaborateurService interventionCollaborateurService;
    @GetMapping("CollaborateurCode/{codeCollaborateur}/InterventionCode/{codeIntervention}")
    public InterventionCollaborateur findByCollaborateurCodeCollaborateurAndInterventionCode(@PathVariable String codeCollaborateur,@PathVariable String codeIntervention) {
        return interventionCollaborateurService.findByCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }
    @DeleteMapping("CollaborateurCode/{codeCollaborateur}/InterventionCode/{codeIntervention}")
    public int deleteByCollaborateurCodeCollaborateurAndInterventionCode(@PathVariable String codeCollaborateur,@PathVariable String codeIntervention) {
        return interventionCollaborateurService.deleteByCollaborateurCodeCollaborateurAndInterventionCode(codeCollaborateur, codeIntervention);
    }
    @PostMapping("/")
    public int save(@RequestBody InterventionCollaborateur interventionCollaborateur) {
        return interventionCollaborateurService.save(interventionCollaborateur);
    }
}
