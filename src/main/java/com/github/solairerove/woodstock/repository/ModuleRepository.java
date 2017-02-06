package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Module;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModuleRepository extends MongoRepository<Module, String> {

}
