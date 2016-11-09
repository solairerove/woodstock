package com.github.solairerove.woodstock.domain;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import com.github.solairerove.woodstock.domain.reference.UnitReference;
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
    private List<UnitReference> references;

    @Relationship(type = "HAS_IN", direction = Relationship.INCOMING)
    private List<Module> modules;

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

    public List<UnitReference> getReferences() {
        if (references == null) {
            references = new ArrayList<>();
        }
        return references;
    }

    public void setReferences(List<UnitReference> references) {
        this.references = references;
    }

    public List<Module> getModules() {
        if (modules == null) {
            modules = new ArrayList<>();
        }

        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
