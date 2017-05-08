package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.ReferenceDTO;
import com.github.solairerove.woodstock.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.solairerove.woodstock.controller.ControllerApi.REFERENCE_API;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = REFERENCE_API, produces = APPLICATION_JSON_UTF8_VALUE)
public class ReferenceController {

    private final ReferenceService service;

    @Autowired
    public ReferenceController(ReferenceService service) {
        this.service = service;
    }

    @RequestMapping(method = POST)
    public ResponseEntity create(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @RequestBody ReferenceDTO referenceDTO) {
        return new ResponseEntity<>(service.create(unitId, moduleId, referenceDTO), CREATED);
    }

    @RequestMapping(path = "/{refId}", method = GET)
    public ResponseEntity get(@PathVariable String unitId,
                              @PathVariable String moduleId,
                              @PathVariable String refId) {
        return new ResponseEntity<>(service.get(unitId, moduleId, refId), OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity getAll(@PathVariable String unitId,
                                 @PathVariable String moduleId) {
        return new ResponseEntity<>(service.getAll(unitId, moduleId), OK);
    }

    @RequestMapping(path = "/{refId}", method = PUT)
    public ResponseEntity update(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @PathVariable String refId,
                                 @RequestBody ReferenceDTO referenceDTO) {
        return new ResponseEntity<>(service.update(unitId, moduleId, refId, referenceDTO), ACCEPTED);
    }

//    @RequestMapping(path = "/{refId}", method = RequestMethod.DELETE)
//    public ResponseEntity delete(@PathVariable Long moduleId, @PathVariable Long refId) {
//        return new ResponseEntity<>(service.delete(moduleId, refId), HttpStatus.ACCEPTED);
//    }
}
