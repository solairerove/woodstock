package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Reference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReferenceRepository extends MongoRepository<Reference, String> {
}
