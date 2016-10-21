package com.github.solairerove.woodstock.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by krivitski-no on 9/14/16.
 */
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Profile")
public class Profile extends BaseEntity {

    private String firstName;

    private String lastName;

    private String createdDate;

    private String updatedDate;
}
