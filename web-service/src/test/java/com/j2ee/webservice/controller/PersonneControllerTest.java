package com.j2ee.webservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.j2ee.webservice.model.Personne;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonneControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetAll() {
		List<Personne> lista = (List<Personne>) this.restTemplate.getForObject("localhost:8080/personnes", Collection.class);
		assertEquals(5, lista.size());
	}

	@Test
	public void testGetById() {
		//list=pc.getAll();
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
