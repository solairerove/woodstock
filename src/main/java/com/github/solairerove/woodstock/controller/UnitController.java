package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.UnitDTO;
import com.github.solairerove.woodstock.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.solairerove.woodstock.controller.ControllerApi.UNIT_API;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(path = UNIT_API, produces = APPLICATION_JSON_UTF8_VALUE)
public class UnitController {

    private final UnitService service;

    @Autowired
    public UnitController(UnitService service) {
        this.service = service;
    }

    @RequestMapping(method = POST)
    public ResponseEntity create(@RequestBody UnitDTO unitDTO) {
        return new ResponseEntity<>(service.create(unitDTO), CREATED);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public ResponseEntity get(@PathVariable String id) {
        return new ResponseEntity<>(service.get(id), OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity getAll() {
        return new ResponseEntity<>(service.getAll(), OK);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    public ResponseEntity update(@PathVariable String id, @RequestBody UnitDTO unitDTO) {
        return new ResponseEntity<>(service.update(id, unitDTO), ACCEPTED);
    }

    @RequestMapping(path = "/{id}", method = DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        return new ResponseEntity<>(service.delete(id), ACCEPTED);
    }
}
