package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Chapter;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface ChapterRepository extends GraphRepository<Chapter> {

    @Query("MATCH (ref:Reference)" +
            "WHERE id(ref)={refId}" +
            "CREATE (ref)-[:HAS_CHAPTER]->(chapter:Chapter {title:{title}, content:{content}})" +
            "RETURN chapter")
    Chapter create(@Param("refId") Long refId, @Param("title") String title, @Param("content") String content);

    @Query("MATCH (ref:Reference)-[:HAS_CHAPTER]->(chapter) " +
            "WHERE id(ref)={refId} AND id(chapter)={chapterId} " +
            "RETURN chapter")
    Chapter getOneThatHasInNode(@Param("refId") Long refId, @Param("chapterId") Long chapterId);

    @Query("MATCH (ref:Reference)-[:HAS_CHAPTER]->(chapters) " +
            "WHERE id(ref)={refId} " +
            "RETURN chapters")
    Iterable<Chapter> getAllThatHasInNode(@Param("refId") Long refId);
}
