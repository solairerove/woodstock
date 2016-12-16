package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Reference;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface ReferenceRepository extends GraphRepository<Reference> {

    @Query("MATCH (module:Module)-[:HAS_REFERENCE]->(ref) " +
            "WHERE id(module)={moduleId} AND id(ref)={refId} " +
            "RETURN ref")
    Reference getOneThatHasInNode(@Param("moduleId") Long moduleId, @Param("refId") Long refId);

    @Query("MATCH (module:Module)-[:HAS_REFERENCE]->(refs) " +
            "WHERE id(module)={moduleId} " +
            "RETURN refs")
    Iterable<Reference> getAllThatHasInNode(@Param("moduleId") Long moduleId);

    @Query("MATCH (n1)<-[r1:HAS_IN]-(n2)<-[r2:HAS_IN]-(n3) " +
            "WHERE id(n1)={moduleId} AND id(n2)={refId} " +
            "DELETE r2, n3, r1, n2")
    void deleteOneThatHasInNode(@Param("moduleId") Long moduleId, @Param("refId") Long refId);
}
