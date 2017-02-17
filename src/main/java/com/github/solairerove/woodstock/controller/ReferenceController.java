package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.github.solairerove.woodstock.controller.ControllerApi.REFERENCE_API;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = REFERENCE_API, produces = APPLICATION_JSON_UTF8_VALUE)
public class ReferenceController {

    private final ReferenceService service;

    @Autowired
    public ReferenceController(ReferenceService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @RequestBody ReferenceDTO referenceDTO) {
        return new ResponseEntity<>(service.create(unitId, moduleId, referenceDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{refId}")
    public ResponseEntity get(@PathVariable String unitId,
                              @PathVariable String moduleId,
                              @PathVariable String refId) {
        return new ResponseEntity<>(service.get(unitId, moduleId, refId), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable String unitId,
                                 @PathVariable String moduleId) {
        return new ResponseEntity<>(service.getAll(unitId, moduleId), HttpStatus.OK);
    }

//    @RequestMapping(path = "/{refId}", method = RequestMethod.PUT)
//    public ResponseEntity update(@PathVariable Long moduleId, @PathVariable Long refId, @RequestBody ReferenceDTO referenceDTO) {
//        return new ResponseEntity<>(service.update(moduleId, refId, referenceDTO), HttpStatus.ACCEPTED);
//    }

//    @RequestMapping(path = "/{refId}", method = RequestMethod.DELETE)
//    public ResponseEntity delete(@PathVariable Long moduleId, @PathVariable Long refId) {
//        return new ResponseEntity<>(service.delete(moduleId, refId), HttpStatus.ACCEPTED);
//    }
}
