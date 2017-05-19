package com.github.solairerove.woodstock.hipster.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Module.
 */
@Entity
@Table(name = "module")
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Unit unit;

    @OneToMany(mappedBy = "module")
    @JsonIgnore
    private Set<Reference> references = new HashSet<>();

    @OneToMany(mappedBy = "module")
    @JsonIgnore
    private Set<Question> questions = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Module name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public Module avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public Module description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Unit getUnit() {
        return unit;
    }

    public Module unit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Set<Reference> getReferences() {
        return references;
    }

    public Module references(Set<Reference> references) {
        this.references = references;
        return this;
    }

    public Module addReferences(Reference reference) {
        this.references.add(reference);
        reference.setModule(this);
        return this;
    }

    public Module removeReferences(Reference reference) {
        this.references.remove(reference);
        reference.setModule(null);
        return this;
    }

    public void setReferences(Set<Reference> references) {
        this.references = references;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Module questions(Set<Question> questions) {
        this.questions = questions;
        return this;
    }

    public Module addQuestion(Question question) {
        this.questions.add(question);
        question.setModule(this);
        return this;
    }

    public Module removeQuestion(Question question) {
        this.questions.remove(question);
        question.setModule(null);
        return this;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Module module = (Module) o;
        if (module.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), module.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Module{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", avatar='" + getAvatar() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
