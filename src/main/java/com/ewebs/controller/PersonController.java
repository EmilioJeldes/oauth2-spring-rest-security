package com.ewebs.controller;

import com.ewebs.domain.Person;
import com.ewebs.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = {"/", ""})
    public Iterable<Person> sayHi() {
        return personService.list();
    }

    @GetMapping("/{id}")
    public Person showPerson(@PathVariable("id") String id) {
        return personService.findPerson(id);
    }

    @PostMapping("/save")
    public Person redirectToSave(@RequestBody Person person) {
        return personService.save(person);
    }

}
