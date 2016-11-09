package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.service.UnitChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/units/{unitId}/chapters", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UnitChapterController {

    private final UnitChapterService service;

    @Autowired
    public UnitChapterController(UnitChapterService service) {
        this.service = service;
    }
}
