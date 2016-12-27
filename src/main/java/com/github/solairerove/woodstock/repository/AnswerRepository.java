package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Answer;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends GraphRepository<Answer> {

    @Query("OPTIONAL MATCH (question:Question)" +
            "WHERE id(question)={questionId}" +
            "CREATE (question)-[:HAS_ANSWER]->(answer:Answer {answer:{answer}, correct:{correct}, enable:{enable}})" +
            "RETURN answer")
    Answer create(@Param("questionId") Long questionId,
                  @Param("answer") String answer, @Param("correct") boolean correct, @Param("enable") boolean enable);

    @Query("OPTIONAL MATCH (question:Question)-[:HAS_ANSWER]->(answer)" +
            "WHERE id(question)={questionId} AND id(answer)={answerId}" +
            "RETURN answer")
    Answer get(@Param("questionId") Long questionId, @Param("answerId") Long answerId);

    @Query("OPTIONAL MATCH (question:Question)-[:HAS_ANSWER]->(answers)" +
            "WHERE id(question)={questionId}" +
            "RETURN answers")
    List<Answer> getAll(@Param("questionId") Long questionId);

    @Query("OPTIONAL MATCH (question:Question)-[:HAS_ANSWER]->(answer:Answer)" +
            "WHERE id(question)={questionId} AND id(answer)={answerId}" +
            "SET answer+={answer:{answer}, correct:{correct}, enable:{enable}}" +
            "RETURN answer")
    Answer update(@Param("questionId") Long questionId, @Param("answerId") Long answerId,
                  @Param("answer") String answer, @Param("correct") boolean correct, @Param("enable") boolean enable);
}
