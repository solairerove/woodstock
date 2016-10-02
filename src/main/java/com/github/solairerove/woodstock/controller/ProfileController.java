package com.github.solairerove.woodstock.controller;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import com.github.solairerove.woodstock.service.ProfileService;
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
 * Created by krivitski-no on 9/14/16.
 */
@RestController
@ExposesResourceFor(Profile.class)
@RequestMapping(value = "/api/profiles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private PagedResourcesAssembler<Profile> assembler;

    @Autowired
    private EntityLinks entityLinks;

    @RequestMapping
    public ResponseEntity<?> getAllProfiles(Pageable pageable) {
        return new ResponseEntity<>(assembler.toResource(profileService.findAll(pageable)), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<?> getProfile(@PathVariable String id) {
        Resource<Profile> resource = new Resource<>(profileService.getProfile(id));
        resource.add(this.entityLinks.linkToSingleResource(Profile.class, id));

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createProfile(@RequestBody ProfileDTO profileDTO) {
        return new ResponseEntity<>(profileService.createProfile(profileDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProfile(@PathVariable String id, @RequestBody ProfileDTO profileDTO) {
        return new ResponseEntity<>(profileService.updateProfile(id, profileDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProfile(@PathVariable String id) {
        return new ResponseEntity<>(profileService.deleteProfile(id), HttpStatus.OK);
    }
    @RequestMapping(path = "/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAll() {
        return new ResponseEntity<>(profileService.deleteAll(), HttpStatus.ACCEPTED);
    }

}
