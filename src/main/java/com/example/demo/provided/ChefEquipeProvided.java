package com.example.demo.provided;


import com.example.demo.bean.ChefEquipe;
import com.example.demo.service.ChefEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chef-equipe")
public class ChefEquipeProvided {
    @Autowired
    private ChefEquipeService chefEquipeService;

    public ChefEquipe findByLogin(String login) {
        return chefEquipeService.findByLogin(login);
    }

    @PostMapping("/seconnecter")
    public ChefEquipe seconnecter(@RequestBody ChefEquipe chefAgence) {
        return chefEquipeService.seconnecter(chefAgence);
    }

    @GetMapping("/code{code}")
    public ChefEquipe findByCode(@PathVariable String code) {
        return chefEquipeService.findByCode(code);
    }
    @GetMapping("/id/{id}")
    public Optional<ChefEquipe> findById(@PathVariable Long id) {
        return chefEquipeService.findById(id);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return chefEquipeService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<ChefEquipe> findAll() {
        return chefEquipeService.findAll();
    }
    @PostMapping("/")
    public ChefEquipe save(@RequestBody ChefEquipe chefEquipe) {
        return chefEquipeService.save(chefEquipe);
    }
    @PutMapping("/")
    public ChefEquipe update(@RequestBody ChefEquipe chefEquipe) {
        return chefEquipeService.update(chefEquipe);
    }
}
