package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.service.mapper.ModelMapper;
import com.github.solairerove.woodstock.service.util.ServiceUtil;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.domain.Unit;
import com.github.solairerove.woodstock.dto.QuestionDTO;
import com.github.solairerove.woodstock.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final UnitRepository repository;

    private final ServiceUtil util;

    @Autowired
    public QuestionService(UnitRepository repository, ServiceUtil util) {
        this.repository = repository;
        this.util = util;
    }

//    public Question create(String unitId, String moduleId, QuestionDTO dto) {
//        Question question = ModelMapper.convertToQuestion(dto);
//
//        Unit unit = repository.findOne(unitId);
//
//        // TODO: add method in utils
//        unit.getModules()
//                .stream()
//                .filter(module$ -> module$.getId().equals(moduleId))
//                .findFirst()
//                .orElse(null)
//                .getQuestions()
//                .add(question);
//        repository.save(unit);
//
//        return question;
//    }
//
//    public Question get(String unitId, String moduleId, String questionId) {
//        return this.util.getQuestion(unitId, moduleId, questionId);
//    }
//
//    public List<Question> getAll(String unitId, String moduleId) {
//        return this.util.getQuestions(unitId, moduleId);
//    }
}
