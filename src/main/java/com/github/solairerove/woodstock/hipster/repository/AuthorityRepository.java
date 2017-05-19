package com.github.solairerove.woodstock.hipster.repository;

import com.github.solairerove.woodstock.hipster.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
