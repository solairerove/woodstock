package com.github.solairerove.service.mapper;

import com.github.solairerove.domain.*;
import com.github.solairerove.service.dto.UnitDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Unit and its DTO UnitDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UnitMapper extends EntityMapper <UnitDTO, Unit> {
    
    @Mapping(target = "modules", ignore = true)
    Unit toEntity(UnitDTO unitDTO); 
    default Unit fromId(Long id) {
        if (id == null) {
            return null;
        }
        Unit unit = new Unit();
        unit.setId(id);
        return unit;
    }
}
