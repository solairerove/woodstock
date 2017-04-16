package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "questions")
public class Question implements Serializable {

    @Id
    private String id;

    private String question;

    private List<String> answers;

    public Question() {
        this.answers = new ArrayList<>();
    }

    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    public void add(String answer) {
        this.answers.add(answer);
    }
}
