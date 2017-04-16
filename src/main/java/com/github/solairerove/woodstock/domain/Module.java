package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "modules")
public class Module implements Serializable {

    @Id
    private String id;

    private String name;

    private String avatar;

    private String description;

    private List<String> references;

    private List<String> questions;

    public Module() {
        this.references = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    public Module(String name, String avatar, String description) {
        this.name = name;
        this.avatar = avatar;
        this.description = description;
        this.references = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    public void addReference(String reference) {
        this.references.add(reference);
    }

    public void addQuestion(String question) {
        this.questions.add(question);
    }
}
