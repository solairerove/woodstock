package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface GenericRepository<T extends BaseEntity> extends GraphRepository<T> {

}
