package com.github.solairerove.woodstock.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UnitDTO implements Serializable {

    private String label;

    private String avatar;

    private String description;
}
