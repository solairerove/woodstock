package com.github.solairerove.woodstock.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UnitDTO implements Serializable {

    private String label;

    private String avatar;

    private String description;

    private boolean featured;

    public UnitDTO() {
    }

    public UnitDTO(String label, String avatar, String description) {
        this.label = label;
        this.avatar = avatar;
        this.description = description;
    }
}
