package br.com.nova.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.nova.erudio.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;

	}

	public Person findByid(String id) {

		logger.info("Find one person");

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstname("Gustavo");
		person.setLastname("Leiroz");
		person.setAddress("São Paulo");
		person.setGender("Masculino");

		return person;
	}

	public Person create(Person person) {
		
		logger.info("Create One Person");
		
		
		return person;
	}
	
	public Person update(Person person) {
		
		logger.info("Updating person");
		
		
		return person;
	}

	public void delete(String id) {
		
		logger.info("Delete person");
	}

	private Person mockPerson(int i) {
		
		logger.info("Find All People");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstname("Person name" + i);
		person.setLastname("Last name" + i);
		person.setAddress("Some address in Brazil" + i);
		person.setGender("Masculino");

		return person;
	}
}
