package br.unb.joilton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unb.joilton.model.Person;
import br.unb.joilton.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonServices personServices;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		
		return personServices.findAll();
	
	}
	
	@RequestMapping(value = "/{pId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("pId") String pId) {
		
		return personServices.findById(pId);
	
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person pPerson) {
		
		return personServices.create(pPerson);
	
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person pPerson) {
		
		return personServices.update(pPerson);
	
	}	
	
	@RequestMapping(value = "/{pId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("pId") String pId) {
		
		personServices.delete(pId);
	
	}
	
}