package com.github.solairerove.woodstock.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by krivitski-no on 9/28/16.
 */
@Getter
@Setter
@NoArgsConstructor
@NodeEntity(label = "Ticket")
public class Ticket extends BaseEntity {

    private String value;

    private Boolean enable;

    private Boolean correct;

    private String createdDate;

    private String updatedDate;
}
