package com.ewebs.service;

import com.ewebs.domain.Person;
import com.ewebs.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Iterable<Person> list() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findPerson(String id) {
        Optional<Person> personOptional = personRepository.findById(Long.parseLong(id));

        if (!personOptional.isPresent()) {
            throw new RuntimeException("No person with id: " + id);
        }
        return personOptional.get();
    }

}
