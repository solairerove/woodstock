package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.domain.Task;
import com.github.solairerove.woodstock.dto.TaskDTO;
import com.github.solairerove.woodstock.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by krivitski-no on 10/3/16.
 */
@RestController
@ExposesResourceFor(Task.class)
@RequestMapping(value = "/api/tasks", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TaskController {

    private final TaskService taskService;

    private final PagedResourcesAssembler<Task> assembler;

    private final EntityLinks entityLinks;

    @Autowired
    public TaskController(TaskService taskService, EntityLinks entityLinks, PagedResourcesAssembler<Task> assembler) {
        this.taskService = taskService;
        this.entityLinks = entityLinks;
        this.assembler = assembler;
    }

    @RequestMapping
    public ResponseEntity getAllTasks(Pageable pageable) {
        return new ResponseEntity<>(assembler.toResource(taskService.findAll(pageable)), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity getTask(@PathVariable String id) {
        Resource<Task> resource = new Resource<>(taskService.get(id));
        resource.add(this.entityLinks.linkToSingleResource(Task.class, id));

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createTask(@RequestBody TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getQuestion());
        return new ResponseEntity<>(taskService.create(task), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateTask(@PathVariable String id, @RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.update(id, taskDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable String id) {
        return new ResponseEntity<>(taskService.delete(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        return new ResponseEntity<>(taskService.deleteAll(), HttpStatus.ACCEPTED);
    }
}
