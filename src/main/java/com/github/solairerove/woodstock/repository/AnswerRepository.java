package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Answer;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends GraphRepository<Answer> {

    @Query("OPTIONAL MATCH (question:Question) " +
            "WHERE id(question)={questionId}" +
            "CREATE (question)-[:HAS_ANSWER]->(answer:Answer {answer:{answer}, correct:{correct}, enable:{enable}})" +
            "RETURN answer")
    Answer create(@Param("questionId") Long questionId,
                  @Param("answer") String answer,
                  @Param("correct") boolean correct,
                  @Param("enable") boolean enable);
}
