package com.github.solairerove.woodstock.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by krivitski-no on 9/13/16.
 */
public class SomeModel implements Serializable {

    @Getter @Setter private String field;
    @Getter @Setter private String someField;
    @Getter @Setter private String someAnotherField;
    @Getter @Setter private String anotherField;

    public SomeModel() {
    }

    public SomeModel(String field, String someField, String someAnotherField, String anotherField) {
        this.field = field;
        this.someField = someField;
        this.someAnotherField = someAnotherField;
        this.anotherField = anotherField;
    }
}
