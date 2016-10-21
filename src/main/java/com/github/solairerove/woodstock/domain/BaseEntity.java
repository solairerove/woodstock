package com.github.solairerove.woodstock.domain;

import org.neo4j.ogm.annotation.GraphId;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    @GraphId
    private Long id;

    private String createdDate;

    private String updatedDate;

    public BaseEntity() {
        // why DATA? why...
    }

    public Long getId() {
        return id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
