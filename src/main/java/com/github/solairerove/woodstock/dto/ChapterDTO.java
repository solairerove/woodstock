package com.github.solairerove.woodstock.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChapterDTO implements Serializable {

    private String title;

    private String content;
}
