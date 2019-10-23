package com.j2ee.webservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.j2ee.webservice.model.Personne;

public class PersonneControllerTest {

	@Test
	public void testGetAll() {
		ArrayList<Personne> personnes = new ArrayList<Personne>();
		assertEquals(5, personnes.size());
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPersonneMapOfStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPersonneStringMapOfStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePersonne() {
		fail("Not yet implemented");
	}

}
