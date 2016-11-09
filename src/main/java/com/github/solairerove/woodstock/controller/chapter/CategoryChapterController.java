package com.github.solairerove.woodstock.controller.chapter;

import com.github.solairerove.woodstock.service.chapter.CategoryChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categories/{categoryId}/chapters", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CategoryChapterController {

    private final CategoryChapterService service;

    @Autowired
    public CategoryChapterController(CategoryChapterService service) {
        this.service = service;
    }
}
