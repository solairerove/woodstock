package com.github.solairerove.woodstock.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by krivitski-no on 10/14/16.
 */
@Data
public class CategoryDTO implements Serializable {

    private String name;

    public CategoryDTO() {
        // why JPA? why...
    }

    public CategoryDTO(String name) {
        this.name = name;
    }
}
