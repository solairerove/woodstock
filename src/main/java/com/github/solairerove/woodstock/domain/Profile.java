package com.github.solairerove.woodstock.domain;

/**
 * Created by krivitski-no on 9/14/16.
 */
public class Profile extends BaseEntity {

    private String firstName;
    private String lastName;

    public Profile() {
        // why JPA? why...
    }

    public Profile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
