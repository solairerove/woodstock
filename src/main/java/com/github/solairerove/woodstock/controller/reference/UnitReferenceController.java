package com.github.solairerove.woodstock.controller.reference;

import com.github.solairerove.woodstock.service.reference.UnitReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/units/{unitId}/reference", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UnitReferenceController {

    private final UnitReferenceService service;

    @Autowired
    public UnitReferenceController(UnitReferenceService service) {
        this.service = service;
    }
}
