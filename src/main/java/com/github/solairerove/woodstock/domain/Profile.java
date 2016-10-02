package com.github.solairerove.woodstock.domain;

import lombok.Data;

/**
 * Created by krivitski-no on 9/14/16.
 */
@Data
public class Profile extends BaseEntity {
    private String firstName;
    private String lastName;

    public Profile() {
    }

    public Profile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
