package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.repository.common.GenericRepository;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;

public interface ModuleRepository extends GenericRepository<Module> {

    @Query("MATCH (n1)<-[:HAS_IN]-(n2) WHERE id(n1)={id1} RETURN n2 LIMIT {size}")
    Iterable<Module> getAllThatHasInNode(@Param("id1") Long id1, @Param("size") Integer size);
}
