package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Answer;
import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.dto.AnswerDTO;
import com.github.solairerove.woodstock.repository.AnswerRepository;
import com.github.solairerove.woodstock.repository.QuestionRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.solairerove.woodstock.utils.AnswerGenerator.generateAnswer;
import static com.github.solairerove.woodstock.utils.AnswerGenerator.generateAnswerDTO;
import static com.github.solairerove.woodstock.utils.QuestionGenerator.generateQuestion;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnswerServiceTest {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerService answerService;

    @After
    @Before
    public void setUp() {
        answerRepository.deleteAll();
        questionRepository.deleteAll();
    }

    @Test
    public void createAnswerTest() {
        Question savedQuestion = generateQuestion();
        Long questionId = questionRepository.save(savedQuestion).getId();

        AnswerDTO answerDTO = generateAnswerDTO();
        Long answerId = answerService.create(questionId, answerDTO).getId();

        assertEquals(answerDTO.getAnswer(), questionRepository.findOne(questionId).getAnswers().get(0).getAnswer());
        assertEquals(answerDTO.isCorrect(), questionRepository.findOne(questionId).getAnswers().get(0).isCorrect());
        assertEquals(answerDTO.isEnable(), questionRepository.findOne(questionId).getAnswers().get(0).isEnable());
        assertEquals(answerDTO.getAnswer(), answerRepository.findOne(answerId).getAnswer());
    }

    @Test
    public void getAnswerTest() {
        Question savedQuestion = generateQuestion();
        Long questionId = questionRepository.save(savedQuestion).getId();

        Answer savedAnswer = generateAnswer();
        questionRepository.findOne(questionId).getAnswers().add(savedAnswer);
        Long answerId = savedAnswer.getId();

        assertEquals(savedAnswer, answerService.get(questionId, answerId));
    }
}
