package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "answers")
public class Answer implements Serializable {

    @Id
    private String id;

    private String answer;

    private boolean correct;

    private boolean enable;

    public Answer() {
        this.init();
    }

    private void init() {
        this.id = ObjectId.get().toHexString();
    }
}
