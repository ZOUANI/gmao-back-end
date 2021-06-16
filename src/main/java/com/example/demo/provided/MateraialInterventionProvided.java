package com.example.demo.provided;

import java.util.List;

import com.example.demo.bean.MateraialIntervention;
import com.example.demo.service.MateraialInterventionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MaterialIntervention-api/Materialintervention")
public class MateraialInterventionProvided {
    @Autowired
    MateraialInterventionService materaialInterventionService;

    @GetMapping("findref/{reference}/findcode/{code}")
    public MateraialIntervention findByMaterialReferenceAndInterventionCode(@PathVariable String reference,
            @PathVariable String code) {
        return materaialInterventionService.findByMaterialReferenceAndInterventionCode(reference, code);
    }

    @DeleteMapping("material/{reference}/Mag/{ref}/interv/{code}")
    public int deleteByMaterialReferenceAndMagasinReference(@PathVariable String reference, @PathVariable String ref,
            @PathVariable String code) {
        return materaialInterventionService.deleteByMaterialReferenceAndMagasinReference(reference, ref, code);
    }

    @DeleteMapping("deleteref/{reference}/deletecode/{code}")
    public int deleteByMaterialReferenceAndInterventionCode(@PathVariable String reference, @PathVariable String code) {
        return materaialInterventionService.deleteByMaterialReferenceAndInterventionCode(reference, code);
    }

    @PostMapping("/")
    public int save(@RequestBody MateraialIntervention materaialIntervention) {
        return materaialInterventionService.save(materaialIntervention);
    }

    @GetMapping("/intervcode/{codeIterv}/colabcode/{codeColab}")
    public List<MateraialIntervention> findByInterventionCodeAndCollaborateurCode(@PathVariable String codeIterv,
            @PathVariable String codeColab) {
        return materaialInterventionService.findByInterventionCodeAndCollaborateurCode(codeIterv, codeColab);
    }

    @GetMapping("/intervention/{code}")
    public List<MateraialIntervention> findByInterventionCode(@PathVariable String code) {
        return materaialInterventionService.findByInterventionCode(code);
    }
}
