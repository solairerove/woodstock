package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Task;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends GraphRepository<Task> {

    @Query("MATCH (module:Module) OPTIONAL " +
            "MATCH (module)<-[r:HAS_IN]-(task:Task) " +
            "WHERE id(module)={moduleId} AND id(task)={taskId} " +
            "RETURN task, r " +
            "LIMIT 150")
    Task getTaskThatHasInModuleFromId(@Param("moduleId") Long moduleId, @Param("taskId") Long taskId);

    @Query("START module=node(*) " +
            "MATCH (module:Module)<-[:HAS_IN*0..]-(tasks:Task) " +
            "WHERE id(module)={id} " +
            "RETURN tasks " +
            "LIMIT 600")
    Iterable<Task> getTasksThatHasInModuleFromId(@Param("id") Long id);
}
