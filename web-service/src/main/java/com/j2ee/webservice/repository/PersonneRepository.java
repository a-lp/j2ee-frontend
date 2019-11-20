package com.j2ee.webservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.j2ee.webservice.model.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Long>{

}
