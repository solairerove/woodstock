package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Task;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends GraphRepository<Task> {

    @Query("MATCH (category:Category) OPTIONAL " +
            "MATCH (category)<-[r:HAS_IN]-(task:Task) " +
            "WHERE id(category)={categoryId} AND id(task)={taskId} " +
            "RETURN task, r " +
            "LIMIT 150")
    Task getTaskThatHasInCategoryFromId(@Param("categoryId") Long categoryId, @Param("taskId") Long taskId);

    @Query("START category=node(*) " +
            "MATCH (category:Category)<-[:HAS_IN*0..]-(tasks:Task) " +
            "WHERE id(category)={id} " +
            "RETURN tasks " +
            "LIMIT 5")
    Iterable<Task> getTasksThatHasInCategoryFromId(@Param("id") Long id);
}
