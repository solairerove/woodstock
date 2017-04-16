package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.ModuleDTO;
import com.github.solairerove.woodstock.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.solairerove.woodstock.controller.ControllerApi.MODULE_API;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = MODULE_API, produces = APPLICATION_JSON_UTF8_VALUE)
public class ModuleController {

    private final ModuleService service;

    @Autowired
    public ModuleController(ModuleService service) {
        this.service = service;
    }

    @RequestMapping(method = POST)
    public ResponseEntity create(@PathVariable String unitId, @RequestBody ModuleDTO moduleDTO) {
        return new ResponseEntity<>(service.create(unitId, moduleDTO), CREATED);
    }

//    @RequestMapping(path = "/{moduleId}", method = GET)
//    public ResponseEntity get(@PathVariable String unitId, @PathVariable String moduleId) {
//        return new ResponseEntity<>(service.get(unitId, moduleId), OK);
//    }
//
//    @RequestMapping(method = GET)
//    public ResponseEntity getAll(@PathVariable String unitId) {
//        return new ResponseEntity<>(service.getAll(unitId), OK);
//    }

    @RequestMapping(path = "/{moduleId}", method = PUT)
    public ResponseEntity update(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @RequestBody ModuleDTO moduleDTO) {
        return new ResponseEntity<>(service.update(unitId, moduleId, moduleDTO), ACCEPTED);
    }

//    @RequestMapping(path = "/{moduleId}", method = DELETE)
//    public ResponseEntity delete(@PathVariable String unitId, @PathVariable String moduleId) {
//        return new ResponseEntity<>(service.delete(unitId, moduleId), ACCEPTED);
//    }
}
