package com.github.solairerove.woodstock.hipster.service.mapper;

import com.github.solairerove.woodstock.hipster.domain.*;
import com.github.solairerove.woodstock.hipster.service.dto.QuestionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Question and its DTO QuestionDTO.
 */
@Mapper(componentModel = "spring", uses = {ModuleMapper.class, })
public interface QuestionMapper extends EntityMapper <QuestionDTO, Question> {
    @Mapping(source = "module.id", target = "moduleId")
    QuestionDTO toDto(Question question); 
    @Mapping(source = "moduleId", target = "module")
    @Mapping(target = "answers", ignore = true)
    Question toEntity(QuestionDTO questionDTO); 
    /**
     * generating the fromId for all mappers if the databaseType is sql, as the class has relationship to it might need it, instead of
     * creating a new attribute to know if the entity has any relationship from some other entity
     *
     * @param id id of the entity
     * @return the entity instance
     */
     
    default Question fromId(Long id) {
        if (id == null) {
            return null;
        }
        Question question = new Question();
        question.setId(id);
        return question;
    }
}
