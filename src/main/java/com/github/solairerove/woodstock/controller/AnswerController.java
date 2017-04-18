package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.AnswerDTO;
import com.github.solairerove.woodstock.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.solairerove.woodstock.controller.ControllerApi.ANSWER_API;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = ANSWER_API, produces = APPLICATION_JSON_UTF8_VALUE)
public class AnswerController {

    private final AnswerService service;

    @Autowired
    public AnswerController(AnswerService service) {
        this.service = service;
    }

    @RequestMapping(method = POST)
    public ResponseEntity create(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @PathVariable String questionId,
                                 @RequestBody AnswerDTO dto) {
        return new ResponseEntity<>(service.create(unitId, moduleId, questionId, dto), CREATED);
    }

    @RequestMapping(path = "/{answerId}", method = GET)
    public ResponseEntity get(@PathVariable String unitId,
                              @PathVariable String moduleId,
                              @PathVariable String questionId,
                              @PathVariable String answerId) {
        return new ResponseEntity<>(service.get(unitId, moduleId, questionId, answerId), OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity getAll(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @PathVariable String questionId) {
        return new ResponseEntity<>(service.getAll(unitId, moduleId, questionId), OK);
    }

    @RequestMapping(path = "/{answerId}", method = PUT)
    public ResponseEntity update(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @PathVariable String questionId,
                                 @PathVariable String answerId,
                                 @RequestBody AnswerDTO dto) {
        return new ResponseEntity<>(service.update(unitId, moduleId, questionId, answerId, dto), OK);
    }
}
