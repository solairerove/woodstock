package com.github.solairerove.woodstock.dto;

import java.io.Serializable;

public class TaskDTO implements Serializable {

    private String question;

    public TaskDTO() {
        // why DATA? why...
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
