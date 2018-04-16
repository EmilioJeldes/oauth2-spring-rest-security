package com.ewebs.bootstrap;

import com.ewebs.domain.Person;
import com.ewebs.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class PersonBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private PersonRepository personRepository;

    @Autowired
    public PersonBootstrap(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        personRepository.saveAll(getPersons());
        log.debug("Initializing data from Person Bootstrap");
    }

    private List<Person> getPersons() {
        List<Person> personas = new ArrayList<>();
        personas.add(new Person("Emilio", "Jeldes", 27));
        personas.add(new Person("Javiera", "Jeldes", 25));
        personas.add(new Person("Jeannette", "Agüero", 56));
        personas.add(new Person("Carlos", "Jeldes", 60));
        personas.add(new Person("Carlos", "Jeldes", 32));
        personas.add(new Person("Andres", "Jeldes", 31));
        personas.add(new Person("Johana", "Nuñez", 33));
        return personas;
    }
}
