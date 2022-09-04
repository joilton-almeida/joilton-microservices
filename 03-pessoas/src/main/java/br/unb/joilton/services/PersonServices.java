package br.unb.joilton.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.unb.joilton.model.Person;

@Service
public class PersonServices {

	private AtomicLong counter = new AtomicLong();

	public Person create(Person pPerson) {
		return pPerson;
	}
	
	public Person update(Person pPerson) {
		return pPerson;
	}
	
	public void delete(String pId) {
		
	}
	
	public Person findById(String pId) {
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Joilton");
		person.setLastName("Almeida");
		person.setAddress("Brasília");
		person.setGender("Male");
		
		return person;
		
	}
	
	public List<Person> findAll() {
		
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) {
		
			Person person = mockPerson(i);
			
			persons.add(person);
			
		}
		
		return persons;
		
	}
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Joilton " + i);
		person.setLastName("Almeida " + i);
		person.setAddress("Brasília " + i);
		person.setGender("Male");
		
		return person;
	}
	
}