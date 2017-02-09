package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.InnerDTO;
import com.github.solairerove.woodstock.service.impl.InnerServiceImpl;
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
@RequestMapping(path = "/api/domains/{domainId}/inners", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class InnerController {

    private final InnerServiceImpl innerService;

    @Autowired
    public InnerController(InnerServiceImpl innerService) {
        this.innerService = innerService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable String domainId, @RequestBody InnerDTO innerDTO) {
        return new ResponseEntity<>(innerService.create(domainId, innerDTO), HttpStatus.CREATED);
    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable String domainId) {
        return new ResponseEntity<>(innerService.getAll(domainId), HttpStatus.OK);
    }
}
