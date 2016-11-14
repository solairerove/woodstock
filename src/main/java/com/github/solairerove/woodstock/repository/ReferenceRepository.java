package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.repository.common.GenericRepository;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;

public interface ReferenceRepository extends GenericRepository<Reference> {

    @Query("MATCH (module:Module)-[:HAS_REFERENCE]->(ref) " +
            "WHERE id(module)={moduleId} AND id(ref)={refId} " +
            "RETURN ref")
    Reference getOneThatHasInNode(@Param("moduleId") Long moduleId, @Param("refId") Long refId);

    @Query("MATCH (module:Module)-[:HAS_REFERENCE]->(refs) " +
            "WHERE id(module)={moduleId} " +
            "RETURN refs")
    Iterable<Reference> getAllThatHasInNode(@Param("moduleId") Long moduleId);
}
