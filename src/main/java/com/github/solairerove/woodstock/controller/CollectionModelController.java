package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.CollectionModelDTO;
import com.github.solairerove.woodstock.service.impl.CollectionModelServiceImpl;
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
@RequestMapping(value = "/api/models/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CollectionModelController {

    private final CollectionModelServiceImpl service;

    @Autowired
    public CollectionModelController(CollectionModelServiceImpl service) {
        this.service = service;
    }


    @RequestMapping(path = "/collections", method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable String id, @RequestBody CollectionModelDTO dto) {
        return new ResponseEntity<>(service.create(id, dto), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/collections")
    public ResponseEntity getAll(@PathVariable String id) {
        return new ResponseEntity<>(service.getAll(id), HttpStatus.OK);
    }
}
