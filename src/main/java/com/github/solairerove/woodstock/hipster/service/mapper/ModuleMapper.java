package com.github.solairerove.woodstock.hipster.service.mapper;

import com.github.solairerove.woodstock.hipster.domain.*;
import com.github.solairerove.woodstock.hipster.service.dto.ModuleDTO;

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
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Module fromId(Long id) {
        if (id == null) {
            return null;
        }
        Module module = new Module();
        module.setId(id);
        return module;
    }
}
