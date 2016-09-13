package com.github.solairerove.woodstock.domain;

import java.io.Serializable;

/**
 * Created by krivitski-no on 9/13/16.
 */
public class SomeModel implements Serializable {

    private String field;
    private String someField;
    private String someAnotherField;
    private String anotherField;

    public SomeModel() {
    }

    public SomeModel(String field, String someField, String someAnotherField, String anotherField) {
        this.field = field;
        this.someField = someField;
        this.someAnotherField = someAnotherField;
        this.anotherField = anotherField;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSomeField() {
        return someField;
    }

    public void setSomeField(String someField) {
        this.someField = someField;
    }

    public String getSomeAnotherField() {
        return someAnotherField;
    }

    public void setSomeAnotherField(String someAnotherField) {
        this.someAnotherField = someAnotherField;
    }

    public String getAnotherField() {
        return anotherField;
    }

    public void setAnotherField(String anotherField) {
        this.anotherField = anotherField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SomeModel someModel = (SomeModel) o;

        if (field != null ? !field.equals(someModel.field) : someModel.field != null) return false;
        if (someField != null ? !someField.equals(someModel.someField) : someModel.someField != null) return false;
        if (someAnotherField != null ? !someAnotherField.equals(someModel.someAnotherField) : someModel.someAnotherField != null)
            return false;
        return anotherField != null ? anotherField.equals(someModel.anotherField) : someModel.anotherField == null;

    }

    @Override
    public int hashCode() {
        int result = field != null ? field.hashCode() : 0;
        result = 31 * result + (someField != null ? someField.hashCode() : 0);
        result = 31 * result + (someAnotherField != null ? someAnotherField.hashCode() : 0);
        result = 31 * result + (anotherField != null ? anotherField.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SomeModel{" +
                "field='" + field + '\'' +
                ", someField='" + someField + '\'' +
                ", someAnotherField='" + someAnotherField + '\'' +
                ", anotherField='" + anotherField + '\'' +
                '}';
    }
}
