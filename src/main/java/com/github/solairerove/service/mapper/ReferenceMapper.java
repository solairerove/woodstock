package com.github.solairerove.service.mapper;

import com.github.solairerove.domain.*;
import com.github.solairerove.service.dto.ReferenceDTO;

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
    default Reference fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reference reference = new Reference();
        reference.setId(id);
        return reference;
    }
}
