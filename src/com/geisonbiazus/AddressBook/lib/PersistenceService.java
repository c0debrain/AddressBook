package com.geisonbiazus.AddressBook.lib;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceService {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	private static EntityManager manager;
	
	private PersistenceService() {
	}
	
	public static EntityManager getEntityManager() {
		
		if (manager == null || !manager.isOpen()) {
			manager = factory.createEntityManager();
		}
		
		return manager;
	}

}
