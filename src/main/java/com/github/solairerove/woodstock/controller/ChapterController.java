package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.service.ChapterService;
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
@RequestMapping(value = "/api/units/{unitId}/modules/{moduleId}/references/{refId}/chapters", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ChapterController {

    private final ChapterService service;

    @Autowired
    public ChapterController(ChapterService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @PathVariable String refId,
                                 @RequestBody ChapterDTO chapterDTO) {

        return new ResponseEntity<>(service.create(unitId, moduleId, refId, chapterDTO), HttpStatus.CREATED);
    }

//    @RequestMapping(path = "/{chapterId}")
//    public ResponseEntity get(@PathVariable Long refId, @PathVariable Long chapterId) {
//        return new ResponseEntity<>(service.get(refId, chapterId), HttpStatus.OK);
//    }

    @RequestMapping
    public ResponseEntity getAll(@PathVariable String unitId,
                                 @PathVariable String moduleId,
                                 @PathVariable String refId) {
        return new ResponseEntity<>(service.getAll(unitId, moduleId, refId), HttpStatus.OK);
    }

//    @RequestMapping(path = "/{chapterId}", method = RequestMethod.PUT)
//    public ResponseEntity update(@PathVariable Long refId, @PathVariable Long chapterId, @RequestBody ChapterDTO chapterDTO) {
//        return new ResponseEntity<>(service.update(refId, chapterId, chapterDTO), HttpStatus.ACCEPTED);
//    }
}
