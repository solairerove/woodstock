package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Answer;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.dto.AnswerDTO;
import com.github.solairerove.woodstock.repository.AnswerRepository;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.QuestionRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(final UnitRepository unitRepository,
                         final ModuleRepository moduleRepository,
                         final QuestionRepository questionRepository,
                         final AnswerRepository answerRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public Answer create(String unitId, String moduleId, String questionId, AnswerDTO dto) {
        Answer answer = new Answer(dto.getAnswer(), dto.isCorrect(), dto.isEnable());
        answerRepository.save(answer);
        String id = answer.getId();

        Question question = questionRepository.findOne(questionId);
        question.add(id);
        questionRepository.save(question);

        return answer;
    }

    public Answer get(String unitId, String moduleId, String questionId, String answerId) {
        return answerRepository.findOne(answerId);
    }

    public Iterable<Answer> getAll(String unitId, String moduleId, String questionId) {
        Question question = questionRepository.findOne(questionId);
        List<String> ids = question.getAnswers();

        return answerRepository.findAll(ids);
    }

    public Answer update(String unitId, String moduleId, String questionId, String answerId, AnswerDTO dto) {
        Answer answer = answerRepository.findOne(answerId);
        answer.setAnswer(dto.getAnswer());
        answer.setCorrect(dto.isCorrect());
        answer.setEnable(dto.isEnable());

        return answerRepository.save(answer);
    }
}
