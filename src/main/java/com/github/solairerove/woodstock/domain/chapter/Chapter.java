package com.github.solairerove.woodstock.domain.chapter;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Chapter")
public class Chapter extends BaseEntity {

    private String title;

    private String content;

    public Chapter() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
