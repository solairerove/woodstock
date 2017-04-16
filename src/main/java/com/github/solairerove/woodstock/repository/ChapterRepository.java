package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChapterRepository extends MongoRepository<Chapter, String> {

}
