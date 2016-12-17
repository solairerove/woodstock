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

    @Query("MATCH (module:Module)-[r1:HAS_REFERENCE]->(ref)-[r2:HAS_CHAPTER]->(chapters)" +
            "WHERE id(module)={moduleId} AND id(ref)={refId} " +
            "DELETE r2, chapters, r1, ref")
    void deleteOneThatHasInNode(@Param("moduleId") Long moduleId, @Param("refId") Long refId);
}
