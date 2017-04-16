package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.dto.ChapterDTO;
import com.github.solairerove.woodstock.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.solairerove.woodstock.controller.ControllerApi.CHAPTER_API;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = CHAPTER_API, produces = APPLICATION_JSON_UTF8_VALUE)
public class ChapterController {

    private final ChapterService service;

    @Autowired
    public ChapterController(ChapterService service) {
        this.service = service;
    }

//    @RequestMapping(method = POST)
//    public ResponseEntity create(@PathVariable String unitId,
//                                 @PathVariable String moduleId,
//                                 @PathVariable String refId,
//                                 @RequestBody ChapterDTO chapterDTO) {
//        return new ResponseEntity<>(service.create(unitId, moduleId, refId, chapterDTO), CREATED);
//    }
//
//    @RequestMapping(path = "/{chapterId}", method = GET)
//    public ResponseEntity get(@PathVariable String unitId,
//                              @PathVariable String moduleId,
//                              @PathVariable String refId,
//                              @PathVariable String chapterId) {
//        return new ResponseEntity<>(service.get(unitId, moduleId, refId, chapterId), OK);
//    }
//
//    @RequestMapping(method = GET)
//    public ResponseEntity getAll(@PathVariable String unitId,
//                                 @PathVariable String moduleId,
//                                 @PathVariable String refId) {
//        return new ResponseEntity<>(service.getAll(unitId, moduleId, refId), OK);
//    }
}
