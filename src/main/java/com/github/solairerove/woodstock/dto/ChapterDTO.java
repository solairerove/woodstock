package com.github.solairerove.woodstock.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ChapterDTO implements Serializable {

    private String title;

    private String content;
}
