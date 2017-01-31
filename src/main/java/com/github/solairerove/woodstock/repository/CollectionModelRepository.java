package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.CollectionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollectionModelRepository extends MongoRepository<CollectionModel, String> {

}
