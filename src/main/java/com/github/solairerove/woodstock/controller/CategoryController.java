package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.CategoryDTO;
import com.github.solairerove.woodstock.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/units/{unitId}/categories", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable Long unitId, @RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(service.create(unitId, categoryDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{categoryId}")
    public ResponseEntity get(@PathVariable Long unitId, @PathVariable Long categoryId) {
        return new ResponseEntity<>(service.get(unitId, categoryId), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable Long unitId) {
        return new ResponseEntity<>(service.getAll(unitId), HttpStatus.OK);
    }
}
