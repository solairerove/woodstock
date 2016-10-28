package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Category;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends GraphRepository<Category> {

    @Query("MATCH (unit:Unit) OPTIONAL " +
            "MATCH (unit)<-[r:HAS_IN]-(category:Category) " +
            "WHERE id(unit)={unitId} AND id(category)={categoryId} " +
            "RETURN category, r " +
            "LIMIT 150")
    Category getCategoryThatHasInUnitFromId(@Param("unitId") Long unitId, @Param("categoryId") Long categoryId);

    @Query("START unit=node(*) " +
            "MATCH (unit:Unit)<-[:HAS_IN*0..]-(categories:Category) " +
            "WHERE id(unit)={unitId} " +
            "RETURN categories " +
            "LIMIT 20")
    Iterable<Category> getCategoriesThatHasInUnitFromId(@Param("unitId") Long unitId);
}
