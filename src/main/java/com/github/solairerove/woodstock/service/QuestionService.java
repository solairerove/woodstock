package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Module;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.dto.QuestionDTO;
import com.github.solairerove.woodstock.repository.ModuleRepository;
import com.github.solairerove.woodstock.repository.QuestionRepository;
import com.github.solairerove.woodstock.repository.UnitRepository;
import com.github.solairerove.woodstock.service.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final UnitRepository unitRepository;

    private final ModuleRepository moduleRepository;

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(final UnitRepository unitRepository,
                           final ModuleRepository moduleRepository,
                           final QuestionRepository questionRepository) {
        this.unitRepository = unitRepository;
        this.moduleRepository = moduleRepository;
        this.questionRepository = questionRepository;
    }

    public Question create(String unitId, String moduleId, QuestionDTO dto) {
        Question question = ModelMapper.convertToQuestion(dto);
        questionRepository.save(question);
        String id = question.getId();

        Module module = moduleRepository.findOne(moduleId);
        module.addQuestion(id);
        moduleRepository.save(module);

        return question;
    }

    public Question get(String unitId, String moduleId, String questionId) {
        return questionRepository.findOne(questionId);
    }

    public Iterable<Question> getAll(String unitId, String moduleId) {
        Module module = moduleRepository.findOne(moduleId);
        List<String> ids = module.getQuestions();

        return questionRepository.findAll(ids);
    }

    public Question update(String unitId, String moduleId, String questionId, QuestionDTO dto) {
        Question question = questionRepository.findOne(questionId);
        question.setQuestion(dto.getQuestion());
        questionRepository.save(question);

        return question;
    }
}
