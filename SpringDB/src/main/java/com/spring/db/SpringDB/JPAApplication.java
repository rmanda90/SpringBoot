package com.spring.db.SpringDB;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.spring.db.SpringDB.jdbc.entity.Person;
import com.spring.db.SpringDB.jpa.PersonJPARepository;

//@SpringBootApplication
public class JPAApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJPARepository personJPARepository;

	public static void main(String[] args) {
		SpringApplication.run(JPAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Created -> Row {}", 
				personJPARepository.insert(new Person("Kamal", "London", new Date())));
		logger.info("Created -> Row {}", 
				personJPARepository.insert(new Person("Raja", "UK", new Date())));
		logger.info("Created -> Row {}", 
				personJPARepository.insert(new Person("Sekhar", "MP", new Date())));
		logger.info("Created -> Row {}", 
				personJPARepository.insert(new Person("AK", "UP", new Date())));
		logger.info("Created -> Row {}", 
				personJPARepository.insert(new Person("PK", "Luknow", new Date())));	
		
		
		logger.info("Data From Table for a Person -> {}", personJPARepository.findById(1));
		
		personJPARepository.deleteById(2);
		
		logger.info("Read -> Data From Table -> {}", personJPARepository.findAll());
	}

}
