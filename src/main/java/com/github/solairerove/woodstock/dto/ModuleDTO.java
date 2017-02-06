package com.github.solairerove.woodstock.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ModuleDTO implements Serializable {

    private String name;

    private String avatar;

    private String description;
}
