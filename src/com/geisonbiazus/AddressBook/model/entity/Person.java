package com.geisonbiazus.AddressBook.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.geisonbiazus.AddressBook.lib.BaseEntity;
import com.geisonbiazus.AddressBook.lib.PersistenceService;

@Entity
public class Person implements BaseEntity {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String name;

	private String address;

	private String district;

	@NotEmpty
	private String city;

	@NotEmpty
	private String state;
	
	public String getFormattedAddress() {
		String formattedAddress = "";		
		String[] addressElements = new String[] {address, district, city, state};
		
		for (String el : addressElements) {
			if (el == null || el.isEmpty())	continue;			
			if (!formattedAddress.isEmpty()) formattedAddress += ", ";			
			formattedAddress += el;
		}		
		
		return formattedAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public static void main(String[] args) {
		PersistenceService.getEntityManager();
	}
}
