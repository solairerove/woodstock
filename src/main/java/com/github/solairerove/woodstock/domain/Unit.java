package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "units")
public class Unit implements Serializable {

    @Id
    private String id;

    private String label;

    private String avatar;

    private String description;

    private List<Module> modules;

    public Unit() {
        this.init();
    }

    private void init() {
        this.modules = new ArrayList<>();
    }

    public List<Module> getModules() {
        if (this.modules == null) {
            this.modules = new ArrayList<>();
        }

        return this.modules;
    }

    public void add(Module module) {
        this.modules.add(module);
    }
}
