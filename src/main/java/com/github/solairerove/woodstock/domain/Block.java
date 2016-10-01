package com.github.solairerove.woodstock.domain;

import lombok.Data;

/**
 * Created by krivitski-no on 10/1/16.
 */
@Data
public class Block extends BaseEntity {
    private Boolean enable;
    private Boolean correct;

    public Block() {
    }
}
