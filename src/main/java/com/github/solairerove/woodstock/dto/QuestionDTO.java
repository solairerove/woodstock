package com.github.solairerove.woodstock.dto;

import java.io.Serializable;

public class QuestionDTO implements Serializable {

    private String question;

    public QuestionDTO() {
    }

    public QuestionDTO(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
