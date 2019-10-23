package com.j2ee.webservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.j2ee.webservice.model.Personne;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonneControllerTest {

	@LocalServerPort
	private int port = 8080;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetAll() {
		List<Personne> lista = this.restTemplate.getForObject("http://localhost:" + port+"/personnes", List.class);
		assertEquals(5, lista.size());
	}

	@Test
	public void testGetById() {
		List<HashMap> lista = this.restTemplate.getForObject("http://localhost:" + port+"/personnes", List.class);
		Personne output = this.restTemplate.getForObject("http://localhost:" + port+"/personnes/2", Personne.class);
		assertEquals(lista.get(1).get("nom"), output.getNom());
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
