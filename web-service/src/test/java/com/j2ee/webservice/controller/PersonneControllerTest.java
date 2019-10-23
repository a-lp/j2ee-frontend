package com.j2ee.webservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonneControllerTest {
	
	@Autowired
	private PersonneController pc = new PersonneController();

	@Test
	public void testGetAll() {
		assertEquals(0, pc.getAll().size());
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
