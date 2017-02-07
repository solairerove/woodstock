package com.github.solairerove.woodstock.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReferenceDTO implements Serializable {

    private String title;

    private String version;
}
