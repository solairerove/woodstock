package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Task;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krivitski-no on 10/2/16.
 */
@Repository
public interface TaskRepository extends GraphRepository<Task> {

}
