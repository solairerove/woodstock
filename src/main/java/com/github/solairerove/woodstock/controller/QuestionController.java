package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.QuestionDTO;
import com.github.solairerove.woodstock.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.solairerove.woodstock.controller.ControllerApi.QUESTION_API;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = QUESTION_API, produces = APPLICATION_JSON_UTF8_VALUE)
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @RequestMapping(method = POST)
    public ResponseEntity create(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @RequestBody QuestionDTO dto) {
        return new ResponseEntity<>(service.create(unitId, moduleId, dto), CREATED);
    }

    @RequestMapping(path = "/{questionId}")
    public ResponseEntity get(@PathVariable String unitId,
                              @PathVariable String moduleId,
                              @PathVariable String questionId) {
        return new ResponseEntity<>(service.get(unitId, moduleId, questionId), OK);
    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable String unitId,
                                 @PathVariable String moduleId) {
        return new ResponseEntity<>(service.getAll(unitId, moduleId), OK);
    }
}
