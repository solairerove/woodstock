package com.github.solairerove.woodstock.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by krivitski-no on 10/2/16.
 */
@Data
public class ProfileDTO implements Serializable {

    private String firstName;

    private String lastName;
}
