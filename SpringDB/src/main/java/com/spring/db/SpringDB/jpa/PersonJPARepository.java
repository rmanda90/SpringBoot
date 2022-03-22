package com.spring.db.SpringDB.jpa;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.spring.db.SpringDB.jdbc.entity.Person;

@Repository
@Transactional
public class PersonJPARepository {

	// connect to the database
	@PersistenceContext
	EntityManager entityManager;
	
	// Create
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	// Read
	public List<Person> findAll() {
		TypedQuery<Person> createNamedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return createNamedQuery.getResultList();		
	}

	// Update
	public Person update(Person person) {
		return entityManager.merge(person);
	}

	// Delete
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}


	// Extra Operations find
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
}
