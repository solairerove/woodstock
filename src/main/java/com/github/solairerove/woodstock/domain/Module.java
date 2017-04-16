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

    public List<String> getReferences() {
        if (this.references == null) {
            this.references = new ArrayList<>();
        }

        return this.references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    public List<String> getQuestions() {
        if (this.questions == null) {
            this.questions = new ArrayList<>();
        }

        return this.questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public void addReference(String reference) {
        this.references.add(reference);
    }

    public void addQuestion(String question) {
        this.questions.add(question);
    }
}
