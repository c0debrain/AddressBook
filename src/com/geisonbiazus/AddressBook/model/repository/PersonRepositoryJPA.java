package com.geisonbiazus.AddressBook.model.repository;

import com.geisonbiazus.AddressBook.lib.JPABaseRepository;
import com.geisonbiazus.AddressBook.model.entity.Person;

public class PersonRepositoryJPA extends JPABaseRepository<Person> implements PersonRepository {

	public PersonRepositoryJPA() {
		super(Person.class);
	}
	
}
