package br.com.nova.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nova.erudio.services.PersonServices;
import br.com.nova.erudio.vo.v1.PersonVO;
import br.com.nova.erudio.vo.v2.PersonVOV2;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices personServices;
	// private PersonServices personServices = new PersonServices();

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
		return personServices.findByid(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		personServices.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() {
		return personServices.findAll();
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			     consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public PersonVO create(@RequestBody PersonVO person) {
		return personServices.create(person);
	}
 
	@PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE,
		     consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return personServices.createV2(person);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	
	public PersonVO update(@RequestBody PersonVO person) {
		return personServices.update(person);
	}

}
