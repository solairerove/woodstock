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

    private boolean featured;

    private List<String> modules;

    public Unit() {
        this.modules = new ArrayList<>();
    }

    public Unit(String label, String avatar, String description) {
        this.label = label;
        this.avatar = avatar;
        this.description = description;
        this.modules = new ArrayList<>();
    }

    public void add(String module) {
        this.modules.add(module);
    }

    public void delete(String module) {
        this.modules.remove(module);
    }
}
