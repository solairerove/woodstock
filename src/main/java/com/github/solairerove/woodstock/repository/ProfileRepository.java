package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by krivitski-no on 9/14/16.
 */
public interface ProfileRepository extends MongoRepository<Profile, String> {
    @Query("{ 'id' : ?0 }")
    Profile findOneProfileById(String id);
}
