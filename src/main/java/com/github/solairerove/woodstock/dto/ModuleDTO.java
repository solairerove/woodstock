package com.github.solairerove.woodstock.dto;

import java.io.Serializable;

public class ModuleDTO implements Serializable {

    private String name;

    private String avatar;

    private String description;

    public ModuleDTO() {
    }

    public ModuleDTO(String name, String avatar, String description) {
        this.name = name;
        this.avatar = avatar;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
