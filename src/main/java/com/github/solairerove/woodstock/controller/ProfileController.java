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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Profile.class)
@RequestMapping(value = "/api/profiles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProfileController {

    private final ProfileService service;

    private final PagedResourcesAssembler<Profile> assembler;

    private final EntityLinks entityLinks;

    @Autowired
    public ProfileController(ProfileService service, PagedResourcesAssembler<Profile> assembler, EntityLinks entityLinks) {
        this.service = service;
        this.assembler = assembler;
        this.entityLinks = entityLinks;
    }

    @RequestMapping
    public ResponseEntity getAllProfiles(Pageable pageable) {
        return new ResponseEntity<>(assembler.toResource(service.findAll(pageable)), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity getProfile(@PathVariable Long id) {
        Resource<Profile> resource = new Resource<>(service.get(id));
        resource.add(this.entityLinks.linkToSingleResource(Profile.class, id));

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createProfile(@RequestBody ProfileDTO profileDTO) {
        return new ResponseEntity<>(service.create(profileDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) {
        return new ResponseEntity<>(service.update(id, profileDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProfile(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
    @RequestMapping(path = "/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        return new ResponseEntity<>(service.deleteAll(), HttpStatus.ACCEPTED);
    }
}
