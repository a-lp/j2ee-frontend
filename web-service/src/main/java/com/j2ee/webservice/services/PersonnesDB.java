package com.j2ee.webservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.j2ee.webservice.model.Personne;

public class PersonnesDB {
	private static List<Personne> personnes = new ArrayList<Personne>();
	private static int lastId = 0;

	public static List<Personne> getPersonnes() {
		return personnes;
	}

	public static void setPersonnes(List<Personne> list) {
		personnes = Objects.requireNonNull(list);
	}

	public static void addPersonne(Personne p) {
		p.setId(++lastId);
		personnes.add(Objects.requireNonNull(p));
	}

	public static Personne getById(int id) {
		if (id < 0)
			throw new IllegalArgumentException("ID must be greater or equal to 0");
		for (Personne p : personnes) {
			if (p.getId() == id)
				return p;
		}
		return null;
	}

	public static boolean putPersonne(int id, String new_nom, String new_prenom) {
		Personne p = getById(id);
		p.setNom(new_nom);
		p.setPrenom(new_prenom);
		return true;
	}

	public static boolean deletePersonne(int id) {
		Personne p = getById(id);
		personnes.remove(p);
		return true;
	}

}
