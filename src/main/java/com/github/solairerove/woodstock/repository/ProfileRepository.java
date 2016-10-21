package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Profile;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends GraphRepository<Profile> {

    @Query("MATCH (n) WHERE id(n)={0} RETURN n")
    Profile getProfileFromId(Long id);
}
