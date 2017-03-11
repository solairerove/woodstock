package com.github.solairerove.woodstock.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "chapters")
public class Chapter implements Serializable {

    @Id
    private String id;

    private String title;

    private String content;

    public Chapter() {
        this.id = ObjectId.get().toHexString();
    }

    public Chapter(String title, String content) {
        this.id = ObjectId.get().toHexString();
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
