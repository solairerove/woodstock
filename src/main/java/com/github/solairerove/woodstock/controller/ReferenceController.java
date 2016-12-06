package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.service.ReferenceService;
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
@RequestMapping(value = "/api/modules/{moduleId}/references", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ReferenceController {

    private final ReferenceService service;

    @Autowired
    public ReferenceController(ReferenceService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable Long moduleId, @RequestBody ReferenceDTO referenceDTO) {
        return new ResponseEntity<>(service.create(moduleId, referenceDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{refId}")
    public ResponseEntity get(@PathVariable Long moduleId, @PathVariable Long refId) {
        return new ResponseEntity<>(service.get(moduleId, refId), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable Long moduleId) {
        return new ResponseEntity<>(service.getAll(moduleId), HttpStatus.OK);
    }

    @RequestMapping(path = "/{refId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable Long moduleId, @PathVariable Long refId, @RequestBody ReferenceDTO referenceDTO) {
        return new ResponseEntity<>(service.update(moduleId, refId, referenceDTO), HttpStatus.ACCEPTED);
    }
}
