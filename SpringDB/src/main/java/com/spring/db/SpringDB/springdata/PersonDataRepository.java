package com.spring.db.SpringDB.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.db.SpringDB.jdbc.entity.Person;

public interface PersonDataRepository extends JpaRepository<Person, Integer> {

}
