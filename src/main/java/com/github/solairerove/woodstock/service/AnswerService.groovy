package com.github.solairerove.woodstock.service

import com.github.solairerove.woodstock.domain.Answer
import com.github.solairerove.woodstock.dto.AnswerDTO

interface AnswerService {

    Answer create(Long questionId, AnswerDTO answerDTO);

    Answer get(Long questionId, Long answerId);

    List<Answer> getAll(Long questionId);

    Answer update(Long questionId, Long answerId);

    Long delete(Long questionId, Long answerId);
}
