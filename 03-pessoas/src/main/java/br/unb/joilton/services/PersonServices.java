package br.unb.joilton.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.unb.joilton.model.Person;

@Service
public class PersonServices {

	private AtomicLong counter = new AtomicLong();
	
	public Person findById(String pId) {
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Joilton");
		person.setLastName("Almeida");
		person.setAddress("Brasília");
		person.setGender("Male");
		
		return person;
		
	}
}
