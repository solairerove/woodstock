package com.github.solairerove.woodstock.controller.chapter;

import com.github.solairerove.woodstock.service.chapter.ModuleChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/modules/{moduleId}/chapters", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ModuleChapterController {

    private final ModuleChapterService service;

    @Autowired
    public ModuleChapterController(ModuleChapterService service) {
        this.service = service;
    }
}
