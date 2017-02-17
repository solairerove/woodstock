package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.bson.types.ObjectId;
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

    private List<Answer> answers;

    public Question() {
        this.init();
    }

    private void init() {
        this.id = ObjectId.get().toHexString();
        this.answers = new ArrayList<>();
    }

    public List<Answer> getAnswers() {
        if (answers == null) {
            this.answers = new ArrayList<>();
        }
        return this.answers;
    }

    public void add(Answer answer) {
        this.answers.add(answer);
    }
}
