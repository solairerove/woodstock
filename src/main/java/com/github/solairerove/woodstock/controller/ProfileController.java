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

import java.time.LocalDateTime;

/**
 * Created by krivitski-no on 9/14/16.
 */
@RestController
@ExposesResourceFor(Profile.class)
@RequestMapping(value = "/api/profiles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProfileController {

    private final ProfileService profileService;

    private final PagedResourcesAssembler<Profile> assembler;

    private final EntityLinks entityLinks;

    @Autowired
    public ProfileController(ProfileService profileService, PagedResourcesAssembler<Profile> assembler, EntityLinks entityLinks) {
        this.profileService = profileService;
        this.assembler = assembler;
        this.entityLinks = entityLinks;
    }

    @RequestMapping
    public ResponseEntity getAllProfiles(Pageable pageable) {
        return new ResponseEntity<>(assembler.toResource(profileService.findAll(pageable)), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity getProfile(@PathVariable String id) {
        Resource<Profile> resource = new Resource<>(profileService.get(id));
        resource.add(this.entityLinks.linkToSingleResource(Profile.class, id));

        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createProfile(@RequestBody ProfileDTO profileDTO) {
        Profile profile = new Profile(profileDTO.getFirstName(), profileDTO.getLastName());
        profile.setCreatedDate(LocalDateTime.now());
        return new ResponseEntity<>(profileService.create(profile), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateProfile(@PathVariable String id, @RequestBody ProfileDTO profileDTO) {
        return new ResponseEntity<>(profileService.update(id, profileDTO), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProfile(@PathVariable String id) {
        return new ResponseEntity<>(profileService.delete(id), HttpStatus.OK);
    }
    @RequestMapping(path = "/delete_all", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        return new ResponseEntity<>(profileService.deleteAll(), HttpStatus.ACCEPTED);
    }
}
