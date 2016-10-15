package com.github.solairerove.woodstock.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by krivitski-no on 10/2/16.
 */
@Data
public class TaskDTO implements Serializable {

    private String question;

    public TaskDTO() {
        // default contructor
    }

    public TaskDTO(String question) {
        this.question = question;
    }
}
