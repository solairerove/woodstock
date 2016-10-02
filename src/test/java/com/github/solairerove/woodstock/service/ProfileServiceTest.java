package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import com.github.solairerove.woodstock.repository.ProfileRepository;
import com.github.solairerove.woodstock.utils.EntityUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by krivitski-no on 9/28/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ProfileServiceTest {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileRepository profileRepository;

    @Before
    public void setUp() {
        profileRepository.deleteAll();
    }

    @Test
    public void createProfileTest() {
        ProfileDTO saved = EntityUtils.generateProfileDTO();
        String id = profileService.createProfile(saved);

        Assert.assertEquals(saved.getFirstName(), profileRepository.findOne(id).getFirstName());
        Assert.assertEquals(saved.getLastName(), profileRepository.findOne(id).getLastName());
    }

    @Test
    public void getProfileTest() {
        Profile saved = EntityUtils.generateProfile();
        profileRepository.save(saved);

        Assert.assertEquals(saved, profileService.getProfile(saved.getId()));
    }

    @Test
    public void updateProfileTest() {
        Profile saved = EntityUtils.generateProfile();
        profileRepository.save(saved);
        String id = saved.getId();

        ProfileDTO profileDTO = EntityUtils.generateProfileDTO();
        String firstName = EntityUtils.getRandomString();
        String lastName = EntityUtils.getRandomString();
        profileDTO.setFirstName(firstName);
        profileDTO.setLastName(lastName);

        profileService.updateProfile(id, profileDTO);

        Assert.assertEquals(firstName, profileRepository.findOne(id).getFirstName());
        Assert.assertEquals(lastName, profileRepository.findOne(id).getLastName());
    }

    @Test
    public void deleteProfileTest() {
        Profile saved = EntityUtils.generateProfile();
        profileRepository.save(saved);

        profileService.deleteProfile(saved.getId());

        Assert.assertEquals(profileRepository.findOne(saved.getId()), null);
    }

    @Test
    public void deleteAll() {
        profileRepository.save(EntityUtils.generateProfileCollection());

        profileService.deleteAll();

        Assert.assertEquals(0, profileRepository.count());
    }

    @Test
    public void findAllTest() {
        profileRepository.save(EntityUtils.generateProfileCollection());
        int count = EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION;

        Assert.assertEquals(count, profileService.findAll(new PageRequest(0, count)).getTotalElements());
    }
}
