package com.spring.db.SpringDB;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.spring.db.SpringDB.jdbc.DAO.PersonJdbcDAO;
import com.spring.db.SpringDB.jdbc.entity.Person;

//@SpringBootApplication
public class SpringJDBCApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO personJdbcDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Create -> {} Row/s Created", 
				personJdbcDAO.insert(new Person(10004, "Kamal", "London", new Date())));
		
		logger.info("Read -> Data From Table -> {}", personJdbcDAO.findAll());
		
		logger.info("Update -> {} Row/s Updated", 
				personJdbcDAO.update(new Person(10004, "Prasad", "Hyderabad", new Date())));
		
		logger.info("Delete -> {} Row/s are effected", personJdbcDAO.deleteById(10003));
		
		logger.info("Data From Table for a Person -> {}", personJdbcDAO.findById(10001));		
	}

}
