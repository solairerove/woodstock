package com.github.solairerove.woodstock.domain;

/**
 * Created by krivitski-no on 10/1/16.
 */
public class Block extends BaseEntity {

    private Boolean enable;
    private Boolean correct;

    public Block() {
        // why JPA? why...
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
