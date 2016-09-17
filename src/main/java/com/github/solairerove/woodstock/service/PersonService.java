package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Person;
import com.github.solairerove.woodstock.resource.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by krivitski-no on 9/14/16.
 */
@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public String createPerson(Person person) {
        personRepository.save(person);
        return person.getId();
    }

    public Person getPerson(String id) {
        return personRepository.findOnePersonById(id);
    }

    public Person updatePerson(String id, Person person) {
        if (personRepository.exists(id)) {
            person.setId(id);
            createPerson(person);
        }
        return person;
    }

    public String deletePerson(String id) {
        personRepository.delete(id);
        return id;
    }

    public String deletePerson(Person person) {
        personRepository.delete(person);
        return person.getId();
    }

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
