package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Task;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface TaskRepository extends GraphRepository<Task> {

}
