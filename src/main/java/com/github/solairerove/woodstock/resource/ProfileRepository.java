package com.github.solairerove.woodstock.resource;

import com.github.solairerove.woodstock.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by krivitski-no on 9/14/16.
 */
public interface ProfileRepository extends MongoRepository<Profile, String> {

    Profile findOneProfileById(String id);
}
