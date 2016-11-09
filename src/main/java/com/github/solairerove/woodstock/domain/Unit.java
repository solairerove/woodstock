package com.github.solairerove.woodstock.domain;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import com.github.solairerove.woodstock.domain.reference.Reference;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "Unit")
public class Unit extends BaseEntity {

    private String label;

    private String avatar;

    private String description;

    @Relationship(type = "HAS_REFERENCE")
    private Reference reference;

    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
    private List<Category> categories;

    public Unit() {

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public Reference getReference() {
        return reference;
    }

    public List<Category> getCategories() {
        if (categories == null) {
            categories = new ArrayList<>();
        }

        return categories;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
