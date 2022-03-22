package com.spring.db.SpringDB.jdbc.DAO;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.db.SpringDB.jdbc.entity.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	BeanPropertyRowMapper<Person> personBeanPropertyRowMapper = new BeanPropertyRowMapper<Person>(Person.class);

	// Create
	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date ) " + "values(?, ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime()) });
	}

	// Read
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", personBeanPropertyRowMapper);
	}

	// Update
	public int update(Person person) {
		return jdbcTemplate.update("update person set name = ?, location = ?, birth_date = ? where id = ?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime()),person.getId() });
	}

	// Delete
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id = ?", id);
	}

	// Extra Operations find
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id = ?", personBeanPropertyRowMapper, id);
	}
}
