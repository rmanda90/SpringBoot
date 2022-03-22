package com.spring.db.SpringDB;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.db.SpringDB.jdbc.entity.Person;
import com.spring.db.SpringDB.springdata.PersonDataRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonDataRepository personDataRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Created -> Row {}", 
				personDataRepository.save(new Person("Kamal", "London", new Date())));
		logger.info("Created -> Row {}", 
				personDataRepository.save(new Person("Raja", "UK", new Date())));
		logger.info("Created -> Row {}", 
				personDataRepository.save(new Person("Sekhar", "MP", new Date())));
		logger.info("Created -> Row {}", 
				personDataRepository.save(new Person("AK", "UP", new Date())));
		logger.info("Created -> Row {}", 
				personDataRepository.save(new Person("PK", "Luknow", new Date())));	
		
		
		logger.info("Data From Table for a Person -> {}", personDataRepository.findById(1));
		
		personDataRepository.deleteById(2);
		
		logger.info("Read -> Data From Table -> {}", personDataRepository.findAll());
	}

}
