package br.com.wagnerodri;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.wagnerodri.model.Person;

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

	public Person findById(String id) {
		logger.info("finding one Person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFisrtName("Wagner");
		person.setLasttName("Rodrigo");
		person.setAddress("São Paulo - Diadema - Brasil");
		person.setGender("Male");
		
		return person;
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFisrtName("fistname" + i);
		person.setLasttName("lastname" + i);
		person.setAddress("some address in brasil");
		person.setGender("Male");
		
		return person;
	}

	}

