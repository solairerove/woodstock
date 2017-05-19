package com.github.solairerove.woodstock.hipster.repository;

import com.github.solairerove.woodstock.hipster.domain.Unit;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Unit entity.
 */
@SuppressWarnings("unused")
public interface UnitRepository extends JpaRepository<Unit,Long> {

}
