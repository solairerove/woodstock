package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Domain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DomainRepository extends MongoRepository<Domain, String> {

}
