package com.github.solairerove.woodstock.resource;

import com.github.solairerove.woodstock.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by krivitski-no on 9/14/16.
 */
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByFirstName(String name);
}
