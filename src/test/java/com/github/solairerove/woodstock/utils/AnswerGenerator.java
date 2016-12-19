package com.github.solairerove.woodstock.utils;

import com.github.solairerove.woodstock.domain.Answer;
import com.github.solairerove.woodstock.dto.AnswerDTO;

import java.util.ArrayList;
import java.util.List;

import static com.github.solairerove.woodstock.utils.EntityUtils.*;

public class AnswerGenerator {

    public static Answer generateAnswer() {
        Answer answer = new Answer();

        answer.setAnswer(getRandomString());
        answer.setCorrect(getRandomBoolean());
        answer.setEnable(getRandomBoolean());

        return answer;
    }

    public static AnswerDTO generateAnswerDTO() {
        AnswerDTO answerDTO = new AnswerDTO();

        answerDTO.setAnswer(getRandomString());
        answerDTO.setCorrect(getRandomBoolean());
        answerDTO.setCorrect(getRandomBoolean());

        return answerDTO;
    }

    public static List<Answer> generateAnswerCollection() {
        List<Answer> answers = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
            answers.add(generateAnswer());
        }

        return answers;
    }
}
