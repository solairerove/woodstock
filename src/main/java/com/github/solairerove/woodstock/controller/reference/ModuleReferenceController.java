package com.github.solairerove.woodstock.controller.reference;

import com.github.solairerove.woodstock.service.reference.ModuleReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/modules/{moduleId}/references", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ModuleReferenceController {

    private final ModuleReferenceService service;

    @Autowired
    public ModuleReferenceController(ModuleReferenceService service) {
        this.service = service;
    }
}
