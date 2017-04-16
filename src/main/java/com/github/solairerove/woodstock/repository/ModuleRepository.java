package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Module;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by solairerove on 4/16/17.
 */
public interface ModuleRepository extends MongoRepository<Module, String> {
}
