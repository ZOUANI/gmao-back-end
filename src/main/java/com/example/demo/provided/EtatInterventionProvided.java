package com.example.demo.provided;

import com.example.demo.bean.EtatIntervention;
import com.example.demo.service.EtatInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Gmao/etatIntervention")
public class EtatInterventionProvided {
    @Autowired
    EtatInterventionService etatInterventionService;
    @GetMapping("findCode/{code}")
    public EtatIntervention findByCode(String code) {
        return etatInterventionService.findByCode(code);
    }
    @GetMapping("findCouleur/{couleurIntervention}")
    public List<EtatIntervention> findByCouleurIntervention(String couleurIntervention) {
        return etatInterventionService.findByCouleurIntervention(couleurIntervention);
    }

    @DeleteMapping("deleteCode/{code}")
    public int deleteByCode(String code) {
        return etatInterventionService.deleteByCode(code);
    }
}
