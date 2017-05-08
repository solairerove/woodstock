package com.github.solairerove.woodstock.service.mapper;

import com.github.solairerove.woodstock.domain.Answer;
import com.github.solairerove.woodstock.domain.Chapter;
import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.AnswerDTO;
import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.dto.QuestionDTO;
import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.dto.UnitDTO;

public class ModelMapper {

    public static Unit convertToUnit(UnitDTO unitDTO) {
        Unit unit = new Unit();
        unit.setLabel(unitDTO.getLabel());
        unit.setAvatar(unitDTO.getAvatar());
        unit.setFeatured(unitDTO.isFeatured());
        unit.setDescription(unitDTO.getDescription());

        return unit;
    }

    public static Module convertToModule(ModuleDTO moduleDTO) {
        Module module = new Module();
        module.setName(moduleDTO.getName());
        module.setAvatar(moduleDTO.getAvatar());
        module.setDescription(moduleDTO.getDescription());

        return module;
    }

    public static Reference convertToReference(ReferenceDTO referenceDTO) {
        Reference reference = new Reference();
        reference.setTitle(referenceDTO.getTitle());
        reference.setVersion(referenceDTO.getVersion());

        return reference;
    }

    public static Chapter convertToChapter(ChapterDTO chapterDTO) {
        Chapter chapter = new Chapter();
        chapter.setTitle(chapterDTO.getTitle());
        chapter.setContent(chapterDTO.getContent());

        return chapter;
    }

    public static Question convertToQuestion(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setQuestion(questionDTO.getQuestion());

        return question;
    }

    public static Answer convertToAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setAnswer(answerDTO.getAnswer());
        answer.setCorrect(answerDTO.isCorrect());
        answer.setEnable(answerDTO.isEnable());

        return answer;
    }
}
