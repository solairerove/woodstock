package com.github.solairerove.woodstock.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "questions")
public class Question implements Serializable {

    @Id
    private String id;

    private String question;

    private List<Answer> answers;

    public Question() {
        this.id = ObjectId.get().toHexString();
        this.answers = new ArrayList<>();
    }

    public Question(String question) {
        this.id = ObjectId.get().toHexString();
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        if (answers == null) {
            this.answers = new ArrayList<>();
        }

        return this.answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void add(Answer answer) {
        this.answers.add(answer);
    }
}
