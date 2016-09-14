package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krivitski-no on 9/14/16.
 */
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping
    public ResponseEntity<?> getAllPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{firstName}")
    public ResponseEntity<?> getPersonByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(personService.findByFirstName(firstName), HttpStatus.OK);
    }
}
