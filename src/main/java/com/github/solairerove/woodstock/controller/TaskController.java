package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.service.TaskService;
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
@RequestMapping(value = "/api/categories/{categoryId}/tasks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable Long categoryId, @RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(service.create(categoryId, taskDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{taskId}")
    public ResponseEntity get(@PathVariable Long categoryId, @PathVariable Long taskId) {
        return new ResponseEntity<>(service.get(categoryId, taskId), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable Long categoryId) {
        return new ResponseEntity<>(service.getAll(categoryId), HttpStatus.OK);
    }
}
