package com.example.demo.provided;

import java.util.List;

import com.example.demo.bean.Equipe;
import com.example.demo.bean.MembreEquipe;
import com.example.demo.service.MembreEquipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Gmao/membreEquipe")
public class MembreEquipeProvided {
 @Autowired
 private MembreEquipeService membreEquipeService;

 public MembreEquipe findByCollaborateurFullname(String fullname) {
  return membreEquipeService.findByCollaborateurFullname(fullname);
 }

 @GetMapping("/equipe/ref/{ref}")
 public List<MembreEquipe> findByEquipeRef(@PathVariable String ref) {
  return membreEquipeService.findByEquipeRef(ref);
 }

 @DeleteMapping("/collaborateur/fullname/{fullname}")
 public int deleteByCollaborateurFullname(@PathVariable String fullname) {
  return membreEquipeService.deleteByCollaborateurFullname(fullname);
 }

 @GetMapping("/")
 public List<MembreEquipe> findAll() {
  return membreEquipeService.findAll();
 }

 @PostMapping("/")
 public int save(@RequestBody Equipe equipe, @RequestBody MembreEquipe membreEquipe) {
  return membreEquipeService.save(equipe, membreEquipe);
 }
 @GetMapping("/collaborateur/code/{code}")
 public MembreEquipe findByCollaborateurCodeCollaborateur(String code) {
  return membreEquipeService.findByCollaborateurCodeCollaborateur(code);
 }
}
