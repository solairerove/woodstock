package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Profile")
public class Profile extends BaseEntity {

    private String firstName;

    private String lastName;

    public Profile() {

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
