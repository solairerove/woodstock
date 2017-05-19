package com.github.solairerove.woodstock.hipster.service.mapper;

import com.github.solairerove.woodstock.hipster.domain.*;
import com.github.solairerove.woodstock.hipster.service.dto.UnitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Unit and its DTO UnitDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UnitMapper extends EntityMapper <UnitDTO, Unit> {
    
    @Mapping(target = "modules", ignore = true)
    Unit toEntity(UnitDTO unitDTO); 
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Unit fromId(Long id) {
        if (id == null) {
            return null;
        }
        Unit unit = new Unit();
        unit.setId(id);
        return unit;
    }
}
