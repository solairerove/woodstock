package com.github.solairerove.woodstock.controller.reference;

import com.github.solairerove.woodstock.service.reference.CategoryReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categories/{categoryId}/reference", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CategoryReferenceController {

    private final CategoryReferenceService service;

    @Autowired
    public CategoryReferenceController(CategoryReferenceService service) {
        this.service = service;
    }
}
