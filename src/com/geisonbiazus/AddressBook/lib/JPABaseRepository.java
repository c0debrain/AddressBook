package com.geisonbiazus.AddressBook.lib;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JPABaseRepository<T extends BaseEntity> implements Repository<T> {
	
	private Class<T> klass;
	
	public JPABaseRepository(Class<T> klass) {
		this.klass = klass;
	}

	@Override
	public void save(T object) {
		getEntityManager().getTransaction().begin();
		
		if (object.getId() == null || object.getId() == 0) {
			getEntityManager().persist(object);
		} else {
			getEntityManager().merge(object);
		}			
		
		getEntityManager().getTransaction().commit();
	}

	@Override
	public void destroy(T object) {
		getEntityManager().getTransaction().begin();		
		getEntityManager().remove(getEntityManager().getReference(klass, object.getId()));
		getEntityManager().getTransaction().commit();
	}

	@Override
	public T find(Long id) {
		return getEntityManager().find(klass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Query query = getEntityManager().createQuery("select e from " + klass.getName() + " e", klass);
		return query.getResultList();
	}
	
	@Override
	public void close() {
		getEntityManager().close();
	}
	
	public EntityManager getEntityManager() {
		return PersistenceService.getEntityManager();
	}

}
