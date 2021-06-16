package com.example.demo.provided;

import java.util.List;
import java.util.Optional;

import com.example.demo.bean.DemandeConge;
import com.example.demo.service.DemandeCongeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conge")
public class DemandeCongeProvided {
    @GetMapping("/id/{id}")
    public Optional<DemandeConge> findById(Long id) {
        return demandeCongeService.findById(id);
    }

    @GetMapping("/")
    public List<DemandeConge> findAll() {
        return demandeCongeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody DemandeConge demandeConge) {
        return demandeCongeService.save(demandeConge);
    }

    @PutMapping("/code/{code}")
    public int update(@PathVariable String code, @RequestBody DemandeConge demandeConge) {
        return demandeCongeService.update(code, demandeConge);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return demandeCongeService.deleteByCode(code);
    }

    @GetMapping("/code/{code}")
    public DemandeConge findByCode(@PathVariable String code) {
        return demandeCongeService.findByCode(code);
    }

    @GetMapping("/collaborateur/{collaborateur}")
    public List<DemandeConge> findByCollaborateur(@PathVariable String collaborateur) {
        return demandeCongeService.findByCollaborateur(collaborateur);
    }

    @Autowired
    private DemandeCongeService demandeCongeService;

}
