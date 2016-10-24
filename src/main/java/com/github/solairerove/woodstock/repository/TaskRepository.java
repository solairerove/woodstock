package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Task;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends GraphRepository<Task> {

    @Query("MATCH (category:Category)<-[:HAS_IN]-(task) " +
            "WHERE id(category)={categoryId} AND id(task)={taskId} " +
            "RETURN task")
    Task getTaskThatHasInCategoryFromId(@Param("categoryId") Long categoryId, @Param("taskId") Long taskId);

    @Query("MATCH (category:Category)<-[:HAS_IN]->(tasks) " +
            "WHERE id(category)={id} " +
            "RETURN tasks")
    Iterable<Task> getTasksThatHasInCategoryFromId(@Param("id") Long id);
}
