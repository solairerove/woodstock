package com.github.solairerove.service.mapper;

import com.github.solairerove.domain.*;
import com.github.solairerove.service.dto.QuestionDTO;

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
    default Question fromId(Long id) {
        if (id == null) {
            return null;
        }
        Question question = new Question();
        question.setId(id);
        return question;
    }
}
