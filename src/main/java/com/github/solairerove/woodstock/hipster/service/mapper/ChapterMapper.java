package com.github.solairerove.woodstock.hipster.service.mapper;

import com.github.solairerove.woodstock.hipster.domain.*;
import com.github.solairerove.woodstock.hipster.service.dto.ChapterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Chapter and its DTO ChapterDTO.
 */
@Mapper(componentModel = "spring", uses = {ReferenceMapper.class, })
public interface ChapterMapper extends EntityMapper <ChapterDTO, Chapter> {
    @Mapping(source = "reference.id", target = "referenceId")
    ChapterDTO toDto(Chapter chapter); 
    @Mapping(source = "referenceId", target = "reference")
    Chapter toEntity(ChapterDTO chapterDTO); 
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Chapter fromId(Long id) {
        if (id == null) {
            return null;
        }
        Chapter chapter = new Chapter();
        chapter.setId(id);
        return chapter;
    }
}
