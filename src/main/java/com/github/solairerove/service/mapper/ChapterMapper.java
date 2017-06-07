package com.github.solairerove.service.mapper;

import com.github.solairerove.domain.*;
import com.github.solairerove.service.dto.ChapterDTO;

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
    default Chapter fromId(Long id) {
        if (id == null) {
            return null;
        }
        Chapter chapter = new Chapter();
        chapter.setId(id);
        return chapter;
    }
}
