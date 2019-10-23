package com.j2ee.webservice.services;

import java.util.Random;

import com.j2ee.webservice.model.Personne;

public class FuzzerService {

	public static void randomList() {
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			PersonnesDB.addPersonne(new Personne(randomNom(), randomNom()));
		}
	}

	public static String randomNom() {
		StringBuilder result = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 3 + random.nextInt(7); i++) {
			result.append((char) (96 + random.nextInt(26)));
		}
		return result.toString();
	}

}
