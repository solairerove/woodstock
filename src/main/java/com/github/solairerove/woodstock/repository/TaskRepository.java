package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Task;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends GraphRepository<Task> {

}
