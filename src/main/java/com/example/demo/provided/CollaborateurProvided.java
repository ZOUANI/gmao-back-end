package com.example.demo.provided;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Collaborateur;
import com.example.demo.service.CollaborateurService;

@RestController
@RequestMapping("Gmao/collaborateur")


public class CollaborateurProvided {
	@Autowired
	 private CollaborateurService CollaborateurService;
	@GetMapping("/fullname/{fullname}")
	public Collaborateur findByFullname(@PathVariable String fullname) {
		return CollaborateurService.findByFullname(fullname);
	}
	@GetMapping("/codeCollaborateur/{codeCollaborateur}")
	public Collaborateur findByCodeCollaborateur(@PathVariable String codeCollaborateur) {
		return CollaborateurService.findByCodeCollaborateur(codeCollaborateur);
	}
	@GetMapping("/")
	public List<Collaborateur> findAll() {
		return CollaborateurService.findAll();
	}
	 @PostMapping("/")
	public int save(@RequestBody Collaborateur collaborateur) {
		return CollaborateurService.save(collaborateur);
	}
	

}
