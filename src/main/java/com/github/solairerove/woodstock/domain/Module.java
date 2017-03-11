package com.github.solairerove.woodstock.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "modules")
public class Module implements Serializable {

    @Id
    private String id;

    private String name;

    private String avatar;

    private String description;

    private List<Reference> references;

    private List<Question> questions;

    public Module() {
        this.id = ObjectId.get().toHexString();
        this.references = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Reference> getReferences() {
        if (this.references == null) {
            this.references = new ArrayList<>();
        }

        return this.references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }

    public List<Question> getQuestions() {
        if (this.questions == null) {
            this.questions = new ArrayList<>();
        }

        return this.questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addReference(Reference reference) {
        this.references.add(reference);
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }
}
