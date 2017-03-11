package com.github.solairerove.woodstock.dto;

import java.io.Serializable;

public class AnswerDTO implements Serializable {

    private String answer;

    private boolean correct;

    private boolean enable;

    public AnswerDTO() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
