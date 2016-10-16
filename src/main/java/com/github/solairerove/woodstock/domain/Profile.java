package com.github.solairerove.woodstock.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

/**
 * Created by krivitski-no on 9/14/16.
 */
@Data
@NodeEntity(label = "Profile")
public class Profile implements Serializable {

    @GraphId
    private Long id;

    private String firstName;

    private String lastName;

    private String createdDate;

    private String updatedDate;
}
