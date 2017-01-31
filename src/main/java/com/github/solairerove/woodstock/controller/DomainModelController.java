package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.DomainModelDTO;
import com.github.solairerove.woodstock.service.impl.DomainModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/models", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DomainModelController {

    private final DomainModelServiceImpl service;

    @Autowired
    public DomainModelController(DomainModelServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody DomainModelDTO dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @RequestMapping
    public ResponseEntity getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
