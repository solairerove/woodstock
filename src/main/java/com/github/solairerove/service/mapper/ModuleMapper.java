package com.github.solairerove.service.mapper;

import com.github.solairerove.domain.*;
import com.github.solairerove.service.dto.ModuleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Module and its DTO ModuleDTO.
 */
@Mapper(componentModel = "spring", uses = {UnitMapper.class, })
public interface ModuleMapper extends EntityMapper <ModuleDTO, Module> {

    @Mapping(source = "unit.id", target = "unitId")
    ModuleDTO toDto(Module module); 

    @Mapping(source = "unitId", target = "unit")
    @Mapping(target = "references", ignore = true)
    @Mapping(target = "questions", ignore = true)
    Module toEntity(ModuleDTO moduleDTO); 
    default Module fromId(Long id) {
        if (id == null) {
            return null;
        }
        Module module = new Module();
        module.setId(id);
        return module;
    }
}
