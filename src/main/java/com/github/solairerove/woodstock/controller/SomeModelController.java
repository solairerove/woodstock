package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.service.SomeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krivitski-no on 9/13/16.
 */
@RestController
@RequestMapping("/api/model")
public class SomeModelController {

    private final SomeModelService someModelService;

    @Autowired
    public SomeModelController(SomeModelService someModelService) {
        this.someModelService = someModelService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getRandomModel() {
        return new ResponseEntity<>(someModelService.getRandomModel(), HttpStatus.OK);
    }
}
