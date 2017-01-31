package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.DomainModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DomainModelRepository extends MongoRepository<DomainModel, String> {

}
