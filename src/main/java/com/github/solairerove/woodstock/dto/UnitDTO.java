package com.github.solairerove.woodstock.dto;

import java.io.Serializable;

public class UnitDTO implements Serializable {

    private String label;

    private String avatar;

    private String description;

    public UnitDTO() {
    }

    public UnitDTO(String label, String avatar, String description) {
        this.label = label;
        this.avatar = avatar;
        this.description = description;
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
}
