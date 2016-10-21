package com.github.solairerove.woodstock.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by krivitski-no on 10/2/16.
 */
@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO implements Serializable {

    private String firstName;

    private String lastName;
}
