package com.github.solairerove.woodstock.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Document(collection = "answers")
public class Answer implements Serializable {

    @Id
    private String id;

    private String answer;

    private boolean correct;

    private boolean enable;

    public Answer(String answer, boolean correct, boolean enable) {
        this.answer = answer;
        this.correct = correct;
        this.enable = enable;
    }
}
