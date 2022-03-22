package com.spring.db.SpringDB.jdbc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_persons" , query = "select p from Person p")
public class Person {

	@Id	
	private int id;
	
	private String name;
	private String location;
	private Date birth_date;
	
	public Person() {
		super();
	}
	
	public Person(String name, String location, Date birth_date) {
		super();
		this.name = name;
		this.location = location;
		this.birth_date = birth_date;
	}

	public Person(int id, String name, String location, Date birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birth_date = birth_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birth_date=" + birth_date + "]";
	}
}
