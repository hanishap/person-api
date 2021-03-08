package com.spring.crud.demo;

import com.spring.crud.demo.model.Person;
import com.spring.crud.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class SpringBootPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPersonApplication.class, args);
	}

	@Autowired
	private PersonRepository personRepository;

	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			log.info("******* Inserting Persons to DB *******");
			Person person1 = Person.builder().id(1).firstName("Mark").lastName("p").age(30).favouriteColor("blue").build();
			Person person2 = Person.builder().id(2).firstName("John").lastName("p").age(40).favouriteColor("yellow").build();
			personRepository.saveAll(Arrays.asList(person1, person2));

		};
	}

}
