package com.github.solairerove.woodstock.dto;

import java.io.Serializable;

public class ReferenceDTO implements Serializable {

    private String title;

    private String version;

    public ReferenceDTO() {
    }

    public ReferenceDTO(String title, String version) {
        this.title = title;
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
