package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.domain.Person;
import com.github.solairerove.woodstock.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krivitski-no on 9/14/16.
 */
@RestController
@ExposesResourceFor(Person.class)
@RequestMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    private final PersonService personService;

    private final EntityLinks entityLinks;

    @Autowired
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
        Resource<Person> resource = new Resource<>(this.personService.findOnePersonById(id));
        resource.add(this.entityLinks.linkToSingleResource(Person.class, id));

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
}
