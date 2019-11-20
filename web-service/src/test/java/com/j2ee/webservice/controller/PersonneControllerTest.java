package com.j2ee.webservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.j2ee.webservice.model.Personne;
import com.j2ee.webservice.service.PersonneService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonneControllerTest {

	@LocalServerPort
	private int port = 8080;

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	PersonneService personneService;

	private List<Personne> personnes = new ArrayList<Personne>();

	@Before
	public void init() {
		Personne p1 = new Personne(1L, "Pippo", "Pluto");
		Personne p2 = new Personne(2L, "Paperino", "Topolino");
		Personne p3 = new Personne(3L, "Prapa", "Pappo");

		personnes.add(p1);
		personnes.add(p2);
		personnes.add(p3);
		Mockito.when(personneService.getAll()).thenReturn(personnes);
		Mockito.when(personneService.getById("1")).thenReturn(p1);
		Mockito.when(personneService.getById("2")).thenReturn(p2);
		Mockito.when(personneService.getById("3")).thenReturn(p3);
	}

	@Test
	public void testGetAll() {
		List<Personne> lista = this.restTemplate.getForObject("http://localhost:" + port + "/personnes", List.class);
		assertEquals(3, lista.size());
	}

	@Test
	public void testGetById() {
		List<HashMap> lista = this.restTemplate.getForObject("http://localhost:" + port + "/personnes", List.class);
		Personne output = this.restTemplate.getForObject("http://localhost:" + port + "/personnes/2", Personne.class);
		assertEquals(lista.get(1).get("nom"), output.getNom());
	}

	@Test
	public void testPostId() throws URISyntaxException {
		Personne personne = new Personne("Adam", "Gilly");
		Mockito.when(personneService.save(personne)).thenReturn(new Personne(4L, "Adam", "Gilly"));
		Personne request = this.restTemplate.postForObject("http://localhost:" + port + "/personnes", personne,
				Personne.class);
		assertEquals("Adam", request.getNom());
		assertEquals("Gilly", request.getPrenom());
		assertNotNull(request.getId());
	}

	@Test
	public void testUpdatePersonne() {
		Personne updateP1 = new Personne(3L, "Prapa", "Pappo");
		Mockito.when(personneService.save(updateP1)).thenReturn(new Personne(3L, "Prapa", "Pippo"));
		updateP1.setPrenom("Pippo");
		HttpEntity<Personne> updated = new HttpEntity<Personne>(updateP1);
		Personne request = this.restTemplate.exchange("http://localhost:" + port + "/personnes/3", HttpMethod.PUT,
				updated, Personne.class).getBody();
		System.out.println(request);
		assertEquals(updateP1, request);
	}

	@Test
	public void testDeletePersonne() {
		/* Bisogna fare il Mock del servizio per poter lavorare con metodi VOID */
		Personne p1 = new Personne(3L, "Prapa", "Pappo");
		Mockito.when(personneService.remove(p1)).thenReturn(p1);
		Personne response = this.restTemplate
				.exchange("http://localhost:" + port + "/personnes/3", HttpMethod.DELETE, null, Personne.class)
				.getBody();
		assertEquals(Long.valueOf(3L), response.getId());
		assertEquals(p1, response);
	}

}
