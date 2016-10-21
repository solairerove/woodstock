package com.github.solairerove.woodstock.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private String name;

    public CategoryDTO() {
        // why DATA? why...
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
