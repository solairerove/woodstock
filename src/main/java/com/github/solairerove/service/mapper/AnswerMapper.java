package com.github.solairerove.service.mapper;

import com.github.solairerove.domain.*;
import com.github.solairerove.service.dto.AnswerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Answer and its DTO AnswerDTO.
 */
@Mapper(componentModel = "spring", uses = {QuestionMapper.class, })
public interface AnswerMapper extends EntityMapper <AnswerDTO, Answer> {

    @Mapping(source = "question.id", target = "questionId")
    AnswerDTO toDto(Answer answer); 

    @Mapping(source = "questionId", target = "question")
    Answer toEntity(AnswerDTO answerDTO); 
    default Answer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Answer answer = new Answer();
        answer.setId(id);
        return answer;
    }
}
