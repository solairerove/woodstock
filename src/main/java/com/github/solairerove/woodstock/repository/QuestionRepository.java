package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, String> {

}
