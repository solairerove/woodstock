package com.github.solairerove.woodstock.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "answers")
public class Answer implements Serializable {

    @Id
    private String id;

    private String answer;

    private boolean correct;

    private boolean enable;

    public Answer() {
        this.id = ObjectId.get().toHexString();
    }

    public Answer(String answer, boolean correct, boolean enable) {
        this.id = ObjectId.get().toHexString();
        this.answer = answer;
        this.correct = correct;
        this.enable = enable;
    }

    public String getId() {
        return id;
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
