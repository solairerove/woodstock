package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.DomainDTO;
import com.github.solairerove.woodstock.service.impl.DomainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/domains", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DomainController {

    private final DomainServiceImpl domainService;

    @Autowired
    public DomainController(DomainServiceImpl domainService) {
        this.domainService = domainService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody DomainDTO domainDTO) {
        return new ResponseEntity<>(domainService.create(domainDTO), HttpStatus.CREATED);
    }

    @RequestMapping
    public ResponseEntity getAll() {
        return new ResponseEntity<>(domainService.getAll(), HttpStatus.OK);
    }
}
