package com.example.demo.provided;

import java.util.List;

import com.example.demo.bean.Equipe;
import com.example.demo.service.EquipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipe")
public class EquipeProvided {

 @Autowired
 private EquipeService equipeService;

 @DeleteMapping("/reference/{ref}")
 public int deleteByRef(@PathVariable String ref) {
  return equipeService.deleteByRef(ref);
 }

 @GetMapping("/libelle/{libelle}")
 public Equipe findByLibelle(String libelle) {
  return equipeService.findByLibelle(libelle);
 }

 @GetMapping("/Chef/Collaborateur/nom/{fullname}")
 public Equipe findByChefEquipeCollaborateurFullname(@PathVariable String fullname) {
  return equipeService.findByChefEquipeCollaborateurFullname(fullname);
 }

 @GetMapping("/code/{code}")
 public Equipe findByCode(@PathVariable String code) {
  return equipeService.findByCode(code);
 }

 @GetMapping("/reference/{ref}")
 public Equipe findByRef(@PathVariable String ref) {
  return equipeService.findByRef(ref);
 }

 @GetMapping("/")
 public List<Equipe> findAll() {
  return equipeService.findAll();
 }

 @PostMapping("/")
 public int save(@RequestBody Equipe equipe) {
  return equipeService.save(equipe);
 }

}
