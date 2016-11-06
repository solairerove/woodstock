package com.github.solairerove.woodstock.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO implements Serializable {

    private String name;

    private String avatar;

    private String description;

    private String reference;
}
