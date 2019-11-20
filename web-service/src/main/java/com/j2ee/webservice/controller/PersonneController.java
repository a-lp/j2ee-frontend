package com.j2ee.webservice.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.webservice.model.Personne;
import com.j2ee.webservice.service.PersonneService;

@RestController
public class PersonneController {

	@Autowired
	PersonneService personneService;

	@GetMapping("/personnes")
	public Iterable<Personne> getAll() {
		return personneService.getAll();
	}

	@GetMapping("/personnes/{id}")
	public Personne getById(@PathVariable String id) {
		return personneService.getById(id);
	}

	@PostMapping("/personnes")
	@ResponseBody
	public Personne addPersonne(@RequestBody Personne personne) {
		return personneService.save(personne);
	}

	@PutMapping("/personnes/{id}")
	@ResponseBody
	public Personne updatePersonne(@PathVariable String id, @RequestBody Map<String, String> allParams) {
		Personne p = personneService.getById(id);
		p.setNom(allParams.get("nom"));
		p.setPrenom(allParams.get("prenom"));
		return personneService.save(p);
	}

	@DeleteMapping("/personnes/{id}")
	public Personne deletePersonne(@PathVariable String id) {
		return personneService.remove(personneService.getById(id));
	}

}
