package com.j2ee.webservice.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.webservice.model.Personne;
import com.j2ee.webservice.services.FuzzerService;
import com.j2ee.webservice.services.PersonnesDB;

@RestController
public class PersonneController {

	@GetMapping("/personnes")
	public List<Personne> getAll() {
		if (PersonnesDB.getPersonnes().isEmpty()) {
			FuzzerService.randomList();
		}
		return PersonnesDB.getPersonnes();
	}

	@GetMapping("/personnes/{id}")
	public Personne getById(@PathVariable String id) {
		return PersonnesDB.getById(Integer.parseInt(id));
	}

	@PostMapping("/personnes")
	@ResponseBody
	public String setPersonne(@RequestBody Map<String, String> allParams) {
		PersonnesDB.addPersonne(new Personne(Objects.requireNonNull(allParams.get("nom")),
				Objects.requireNonNull(allParams.get("prenom"))));
		return "" + allParams.entrySet() + "\n" + getAll();
	}

	@PutMapping("/personnes/{id}")
	@ResponseBody
	public String setPersonne(@PathVariable String id, @RequestBody Map<String, String> allParams) {
		return PersonnesDB.putPersonne(Integer.parseInt(id), Objects.requireNonNull(allParams.get("nom")),
				Objects.requireNonNull(allParams.get("prenom"))) ? "Put completed" : "Error!";
	}

	@DeleteMapping("/personnes/{id}")
	public String deletePersonne(@PathVariable String id) {
		return PersonnesDB.deletePersonne(Integer.parseInt(id)) ? "Delete completed" : "Error!";
	}
}
