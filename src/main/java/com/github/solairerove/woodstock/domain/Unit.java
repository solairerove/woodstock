package com.github.solairerove.woodstock.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "units")
public class Unit implements Serializable {

    @Id
    private String id;

    private String label;

    private String avatar;

    private String description;

    private List<Module> modules;

    public Unit() {
        this.modules = new ArrayList<>();
    }

    public String getId() {
        return id;
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

    public List<Module> getModules() {
        if (this.modules == null) {
            this.modules = new ArrayList<>();
        }

        return this.modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public void add(Module module) {
        this.modules.add(module);
    }
}
