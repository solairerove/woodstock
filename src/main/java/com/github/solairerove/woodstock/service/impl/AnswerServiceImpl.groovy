package com.github.solairerove.woodstock.service.impl

import com.github.solairerove.woodstock.domain.Answer
import com.github.solairerove.woodstock.dto.AnswerDTO
import com.github.solairerove.woodstock.repository.AnswerRepository
import com.github.solairerove.woodstock.repository.QuestionRepository
import com.github.solairerove.woodstock.service.AnswerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AnswerServiceImpl implements AnswerService {

    private final QuestionRepository questionRepository

    private final AnswerRepository answerRepository

    @Autowired
    AnswerServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository
        this.answerRepository = answerRepository
    }

    @Override
    Answer create(Long questionId, AnswerDTO answerDTO) {
        return answerRepository.create(questionId, answerDTO.getAnswer(), answerDTO.isCorrect(), answerDTO.isEnable())
    }

    @Override
    Answer get(Long questionId, Long answerId) {
        return answerRepository.get(questionId, answerId)
    }

    @Override
    List<Answer> getAll(Long questionId) {
        return null
    }

    @Override
    Answer update(Long questionId, Long answerId) {
        return null
    }

    @Override
    Long delete(Long questionId, Long answerId) {
        return null
    }
}
