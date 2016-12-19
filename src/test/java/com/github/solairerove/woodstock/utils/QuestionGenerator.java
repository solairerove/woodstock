package com.github.solairerove.woodstock.utils;

import com.github.solairerove.woodstock.domain.Question;
import com.github.solairerove.woodstock.dto.QuestionDTO;

import java.util.ArrayList;
import java.util.List;

import static com.github.solairerove.woodstock.utils.EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION;
import static com.github.solairerove.woodstock.utils.EntityUtils.getRandomString;

public class QuestionGenerator {

    public static Question generateQuestion() {
        Question question = new Question();

        question.setQuestion(getRandomString());

        return question;
    }

    public static QuestionDTO generateQuestionDTO() {
        QuestionDTO questionDTO = new QuestionDTO();

        questionDTO.setQuestion(getRandomString());

        return questionDTO;
    }

    public static List<Question> generateQuestionCollection() {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
            questions.add(generateQuestion());
        }

        return questions;
    }
}
