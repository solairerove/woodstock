package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Module;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface ModuleRepository extends GraphRepository<Module> {

    @Query("MATCH (n1)<-[:HAS_IN]-(n2) WHERE id(n1)={id1} AND id(n2)={id2} RETURN n2")
    Module getOneThatHasInNode(@Param("id1") Long id1, @Param("id2") Long id2);

    @Query("MATCH (n1)<-[:HAS_IN]-(n2) WHERE id(n1)={id1} RETURN n2 LIMIT {size}")
    Iterable<Module> getAllThatHasInNode(@Param("id1") Long id1, @Param("size") Integer size);
}
