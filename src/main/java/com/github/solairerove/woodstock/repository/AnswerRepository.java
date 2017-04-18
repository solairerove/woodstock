package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer, String> {

}
