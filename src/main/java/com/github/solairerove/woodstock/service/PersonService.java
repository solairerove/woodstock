package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Person;
import com.github.solairerove.woodstock.resource.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by krivitski-no on 9/14/16.
 */
@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findByFirstName(String name) {
        return personRepository.findByFirstName(name);
    }
}
