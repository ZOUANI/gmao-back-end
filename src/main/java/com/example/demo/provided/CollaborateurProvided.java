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
@RequestMapping("/collaborateur")


public class CollaborateurProvided {
	@Autowired
	 private CollaborateurService collaborateurService;
	@GetMapping("/fullname/{fullname}")
	public Collaborateur findByFullname(@PathVariable String fullname) {
		return collaborateurService.findByFullname(fullname);
	}
	@GetMapping("/codeCollaborateur/{codeCollaborateur}")
	public Collaborateur findByCodeCollaborateur(@PathVariable String codeCollaborateur) {
		return collaborateurService.findByCodeCollaborateur(codeCollaborateur);
	}

	@GetMapping("/")
	public List<Collaborateur> findAll() {
		return collaborateurService.findAll();
	}
	 @PostMapping("/")
	public int save(@RequestBody Collaborateur collaborateur) {
		return collaborateurService.save(collaborateur);
	}
	@GetMapping("/login/{login}")
	public Collaborateur findByLogin(@PathVariable String login) {
		return collaborateurService.findByLogin(login);
	}


	@GetMapping("/signin/{login}/password/{password}")
	public Collaborateur signin(@PathVariable String login,@PathVariable String password) {
		return collaborateurService.signin(login,password);
	}


}
