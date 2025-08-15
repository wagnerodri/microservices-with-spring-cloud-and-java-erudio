package br.com.wagnerodri.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.wagnerodri.PersonServices;
import br.com.wagnerodri.model.Person;


@RestController
@RequestMapping("/person")
public class PersonController  {
	
	@Autowired
	private PersonServices service;
	//private PersonServices service = new PersonServices();
	
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Person> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{id}" , 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public Person findBiId(@PathVariable("id") String id) {
		return service.findById(id);
	}

}
