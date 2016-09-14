package com.github.solairerove.woodstock.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Created by krivitski-no on 9/14/16.
 */
public class Person {

    @Id private String id;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
}
