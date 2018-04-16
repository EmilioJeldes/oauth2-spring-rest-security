package com.ewebs.service;

import com.ewebs.domain.Person;

public interface PersonService {

    Iterable<Person> list();

    Person save(Person person);

    Person findPerson(String id);
}
