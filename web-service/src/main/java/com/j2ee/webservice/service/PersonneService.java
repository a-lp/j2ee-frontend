package com.j2ee.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2ee.webservice.model.Personne;
import com.j2ee.webservice.repository.PersonneRepository;

@Service
public class PersonneService {

	@Autowired
	PersonneRepository personneRepository;

	public Iterable<Personne> getAll() {

		return personneRepository.findAll();
	}

	public Personne save(Personne personne) {
		return personneRepository.save(personne);
	}

	public void update(Personne personne) {
		personneRepository.save(personne);
	}

	public Personne getById(String id) {
		return personneRepository.findById(Long.parseLong(id)).get();
	}

	public Personne remove(Personne personne) {
		personneRepository.delete(personne);
		return personne;
	}

}
