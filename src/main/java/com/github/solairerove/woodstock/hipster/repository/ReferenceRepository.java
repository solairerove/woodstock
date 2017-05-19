package com.github.solairerove.woodstock.hipster.repository;

import com.github.solairerove.woodstock.hipster.domain.Reference;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Reference entity.
 */
@SuppressWarnings("unused")
public interface ReferenceRepository extends JpaRepository<Reference,Long> {

}
