package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Module;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface ModuleRepository extends GenericRepository<Module> {

}
