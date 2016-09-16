package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.domain.Person;
import com.github.solairerove.woodstock.service.PersonService;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by krivitski-no on 9/14/16.
 */
@RestController
@ExposesResourceFor(Person.class)
@RequestMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;
    private final EntityLinks entityLinks;

    public PersonController(EntityLinks entityLinks, PersonService personService) {
        this.entityLinks = entityLinks;
        this.personService = personService;
    }

    @RequestMapping
    public ResponseEntity<?> getAllPersons() {
        Resources<Person> resources = new Resources<>(this.personService.findAll());
        resources.add(this.entityLinks.linkToCollectionResource(Person.class));

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<?> getPerson(@PathVariable String id) {
        Resource<Person> resource = new Resource<>(this.personService.getPerson(id));
        resource.add(this.entityLinks.linkToSingleResource(Person.class, id));

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(@PathVariable String id, @RequestBody Person person) {
        return new ResponseEntity<>(personService.updatePerson(id, person), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(@PathVariable String id) {
        return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePerson(@RequestBody(required = false) Person person) {
        return new ResponseEntity<>(personService.deletePerson(person), HttpStatus.OK);
    }
}
