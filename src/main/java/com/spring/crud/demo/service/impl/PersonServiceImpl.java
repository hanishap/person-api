package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.Person;
import com.spring.crud.demo.repository.PersonRepository;
import com.spring.crud.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;


    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        return personRepository.findById(id).orElseThrow(() -> new NotFoundException("** Person not found for id :: " + id));
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);

    }

    @Override
    public Person update(int id, Person person) {
        personRepository.findById(id).orElseThrow(() -> new NotFoundException("** Person not found for id :: " + id));

        person.setId(id);
        return personRepository.save(person);
    }

    @Override
    public void delete(int id) {
        personRepository.findById(id).ifPresent(Person -> personRepository.delete(Person));
    }

}
