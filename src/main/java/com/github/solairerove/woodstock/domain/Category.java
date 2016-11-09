package com.github.solairerove.woodstock.domain;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import com.github.solairerove.woodstock.domain.reference.CategoryReference;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "Category")
public class Category extends BaseEntity {

    private String name;

    private String avatar;

    private String description;

    @Relationship(type = "HAS_REFERENCE")
    private List<CategoryReference> references;

    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
    private List<Task> tasks;

    public Category() {

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

    public List<CategoryReference> getReferences() {
        if (references == null) {
            references = new ArrayList<>();
        }

        return references;
    }

    public void setReferences(List<CategoryReference> references) {
        this.references = references;
    }

    public List<Task> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }

        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
