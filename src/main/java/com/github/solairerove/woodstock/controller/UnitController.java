package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.UnitDTO;
import com.github.solairerove.woodstock.service.UnitService;
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
@RequestMapping(path = "/api/units", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UnitController {

    private final UnitService service;

    @Autowired
    public UnitController(UnitService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UnitDTO unitDTO) {
        return new ResponseEntity<>(service.create(unitDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity get(@PathVariable String id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable String id, @RequestBody UnitDTO unitDTO) {
        return new ResponseEntity<>(service.update(id, unitDTO), HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.ACCEPTED);
    }
}
