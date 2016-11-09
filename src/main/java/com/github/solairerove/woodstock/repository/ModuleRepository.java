package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Module;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface ModuleRepository extends GraphRepository<Module> {

    @Query("MATCH (unit:Unit) OPTIONAL " +
            "MATCH (unit)<-[r:HAS_IN]-(module:Module) " +
            "WHERE id(unit)={unitId} AND id(module)={moduleId} " +
            "RETURN module, r " +
            "LIMIT 150")
    Module getModuleThatHasInUnitFromId(@Param("unitId") Long unitId, @Param("moduleId") Long moduleId);

    @Query("START unit=node(*) " +
            "MATCH (unit:Unit)<-[:HAS_IN*0..]-(modules:Module) " +
            "WHERE id(unit)={unitId} " +
            "RETURN modules " +
            "LIMIT {limit}")
    Iterable<Module> getModulesThatHasInUnitFromId(@Param("unitId") Long unitId, @Param("limit") Integer limit);
}
