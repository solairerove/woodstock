//package com.github.solairerove.woodstock.repository;
//
//import com.github.solairerove.woodstock.domain.Task;
//import org.springframework.data.neo4j.annotation.Query;
//import org.springframework.data.neo4j.repository.GraphRepository;
//import org.springframework.data.repository.query.Param;
//
//public interface TaskRepository extends GraphRepository<Task> {
//
//    @Query("MATCH (n1)<-[:HAS_IN]-(n2) WHERE id(n1)={id1} AND id(n2)={id2} RETURN n2")
//    Task getOneThatHasInNode(@Param("id1") Long id1, @Param("id2") Long id2);
//
//    @Query("MATCH (n1)<-[:HAS_IN]-(n2) WHERE id(n1)={id1} RETURN n2")
//    Iterable<Task> getAllThatHasInNode(@Param("id1") Long id1);
//
//    @Query("MATCH (n1)<-[r1:HAS_IN]-(n2)<-[r2:HAS_IN]-(n3) WHERE id(n1)={id1} AND id(n2)={id2} DELETE r2, n3, r1, n2")
//    void deleteOneThatHasInNode(@Param("id1") Long id1, @Param("id2") Long id2);
//}
