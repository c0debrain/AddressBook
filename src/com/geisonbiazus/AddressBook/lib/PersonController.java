package com.geisonbiazus.AddressBook.lib;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.geisonbiazus.AddressBook.model.entity.Person;
import com.geisonbiazus.AddressBook.model.repository.PersonRepository;
import com.geisonbiazus.AddressBook.model.repository.PersonRepositoryJPA;

@ManagedBean
@ViewScoped
public class PersonController {
	
	private PersonRepository repository = new PersonRepositoryJPA();
	private Person person = new Person();
	private List<Person> people;
	
	public void newPerson() {
		person = new Person();
	}
	
	public void edit(Person person) {
		this.person = person;
	}
		
	public void save() {
		repository.save(person);
		repository.close();
		newPerson();
		reloadPeopleList();
	}
	
	public void delete(Person person) {
		repository.destroy(person);
		repository.close();
		reloadPeopleList();
	}
	
	public void reloadPeopleList() {
		people = null;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public List<Person> getPeople() {
		if (people == null) {
			people = repository.findAll();
			repository.close();
		}
		return people;
	}
}
