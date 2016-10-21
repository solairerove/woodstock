package com.github.solairerove.woodstock.dto;

import java.io.Serializable;

public class ProfileDTO implements Serializable {

    private String firstName;

    private String lastName;

    public ProfileDTO() {
        // why DATA? why...
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
