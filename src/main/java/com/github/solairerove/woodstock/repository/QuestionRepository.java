package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Question;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface QuestionRepository extends GraphRepository<Question> {

}
