package com.example.demo.provided;

import com.example.demo.bean.DemandeConge;
import com.example.demo.service.DemandeCongeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/conge")
public class DemandeCongeProvided {
    @GetMapping("/id/{id}")
    public Optional<DemandeConge> findById(Long id) {
        return demandeCongeService.findById(id);
    }

    @GetMapping("/code/{code}")
    public List<DemandeConge> findByEtatDemandeCongeCode(String code) {
        return demandeCongeService.findByEtatDemandeCongeCode(code);
    }
    @GetMapping("/")
    public List<DemandeConge> findAll() {
        return demandeCongeService.findAll();
    }

    @PostMapping("/")
    public DemandeConge save(@RequestBody  DemandeConge demandeConge) {
        return demandeCongeService.save(demandeConge);
    }






    @Autowired
    private DemandeCongeService demandeCongeService;

}
