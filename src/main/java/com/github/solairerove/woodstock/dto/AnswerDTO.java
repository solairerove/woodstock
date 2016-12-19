package com.github.solairerove.woodstock.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnswerDTO implements Serializable {

    private String answer;
    private boolean correct;
    private boolean enable;
}
