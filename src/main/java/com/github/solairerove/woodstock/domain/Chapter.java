package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "chapters")
public class Chapter implements Serializable {

    @Id
    private String id;

    private String title;

    private String content;

    public Chapter() {
        this.id = ObjectId.get().toHexString();
    }
}
