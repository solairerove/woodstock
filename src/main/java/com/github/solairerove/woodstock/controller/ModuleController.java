package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/units/{unitId}/modules", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ModuleController {

    private final ModuleService service;

    @Autowired
    public ModuleController(ModuleService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable Long unitId, @RequestBody ModuleDTO moduleDTO) {
        return new ResponseEntity<>(service.create(unitId, moduleDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{moduleId}")
    public ResponseEntity get(@PathVariable Long unitId, @PathVariable Long moduleId) {
        return new ResponseEntity<>(service.get(unitId, moduleId), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable Long unitId, @RequestParam(value = "limit", required = false) Integer limit) {
        return new ResponseEntity<>(service.getAll(unitId, limit), HttpStatus.OK);
    }
}
