package com.example.demo.provided;

import com.example.demo.bean.Intervention;
import com.example.demo.bean.MateraialIntervention;
import com.example.demo.service.MateraialInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/MaterialIntervention-api/Materialintervention")
public class MateraialInterventionProvided {
    @Autowired
    MateraialInterventionService materaialInterventionService;
    @GetMapping("findref/{reference}/findcode/{code}")
    public MateraialIntervention findByMaterialReferenceAndInterventionCode(@PathVariable String reference,@PathVariable String code) {
        return materaialInterventionService.findByMaterialReferenceAndInterventionCode(reference, code);
    }

    @DeleteMapping("deleteref/{reference}/deletecode/{code}")
    public int deleteByMaterialReferenceAndInterventionCode(@PathVariable String reference,@PathVariable String code) {
        return materaialInterventionService.deleteByMaterialReferenceAndInterventionCode(reference, code);
    }
    @PostMapping("/")
    public int save(@RequestBody MateraialIntervention materaialIntervention) {
        return materaialInterventionService.save(materaialIntervention);
    }
}
