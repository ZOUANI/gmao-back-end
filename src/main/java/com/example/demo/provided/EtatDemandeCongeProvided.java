package com.example.demo.provided;

import com.example.demo.bean.EtatDemandeConge;
import com.example.demo.service.EtatDemandeCongeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/etatdemandeconge")
public class EtatDemandeCongeProvided {
    @GetMapping("/code/ {code}")
    public EtatDemandeConge findByCode(@PathVariable String code) {
        return etatDemandeCongeService.findByCode(code);
    }

    @GetMapping("/")
    public List<EtatDemandeConge> findAll() {
        return etatDemandeCongeService.findAll();
    }


    @Autowired
    private EtatDemandeCongeService etatDemandeCongeService;
}

