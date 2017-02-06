package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
public class Module implements Serializable {

    @Id
    private String id;

    private String name;

    private String avatar;

    private String description;

    private Collection<String> references;

    private Collection<String> tasks;

    public Collection<String> getReferences() {
        if (references == null) {
            references = new ArrayList<>();
        }

        return references;
    }

    public Collection<String> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<>();
        }

        return tasks;
    }
}
