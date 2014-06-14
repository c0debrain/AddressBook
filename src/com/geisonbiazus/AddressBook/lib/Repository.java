package com.geisonbiazus.AddressBook.lib;

import java.util.List;

public interface Repository<T extends BaseEntity> {
	
	public void save(T object);
	public void destroy(T object);
	public T find(Long id);	
	public List<T> findAll();
	public void close();

}
