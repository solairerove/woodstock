package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/references/{refId}/chapters", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ChapterController {

    private final ChapterRepository repository;

    @Autowired
    public ChapterController(ChapterRepository repository) {
        this.repository = repository;
    }
}
