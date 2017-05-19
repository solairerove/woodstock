package com.github.solairerove.woodstock.hipster.service.mapper;

import com.github.solairerove.woodstock.hipster.domain.*;
import com.github.solairerove.woodstock.hipster.service.dto.ReferenceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Reference and its DTO ReferenceDTO.
 */
@Mapper(componentModel = "spring", uses = {ModuleMapper.class, })
public interface ReferenceMapper extends EntityMapper <ReferenceDTO, Reference> {
    @Mapping(source = "module.id", target = "moduleId")
    ReferenceDTO toDto(Reference reference); 
    @Mapping(target = "chapters", ignore = true)
    @Mapping(source = "moduleId", target = "module")
    Reference toEntity(ReferenceDTO referenceDTO); 
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Reference fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reference reference = new Reference();
        reference.setId(id);
        return reference;
    }
}
