package com.spring.crud.demo.service;

import com.spring.crud.demo.model.Person;

import java.util.List;

public interface PersonService {

    List<?> findAll();

    Person findById(int id);

    Person save(Person person);

    Person update(int id, Person t);

    void delete(int id);
}
