package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Document
public class Unit implements Serializable {

    @Id
    private String id;

    private String label;

    private String avatar;

    private String description;

    private Collection<String> modules;

    public Collection<String> getModules() {
        if (this.modules == null) {
            this.modules = new ArrayList<>();
        }

        return modules;
    }
}
