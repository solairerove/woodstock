package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Profile;
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
    private static final int NUMBER_OF_ENTITIES_IN_COLLECTION = 10;

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
        Profile saved = EntityUtils.generateProfile();
        profileService.createProfile(saved);

        Assert.assertEquals(saved, profileRepository.findOne(saved.getId()));
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
        Profile updated = EntityUtils.generateProfile();
        profileRepository.save(saved);

        profileService.updateProfile(saved.getId(), updated);

        Assert.assertEquals(updated.getFirstName(), profileRepository.findOne(saved.getId()).getFirstName());
    }

    @Test
    public void deleteProfileTest() {
        Profile saved = EntityUtils.generateProfile();
        profileRepository.save(saved);

        profileService.deleteProfile(saved.getId());

        Assert.assertEquals(profileRepository.findOne(saved.getId()), null);
    }

    @Test
    public void deleteProfileByEntityTest() {
        Profile saved = EntityUtils.generateProfile();
        profileRepository.save(saved);

        profileService.deleteProfile(saved);

        Assert.assertEquals(profileRepository.findOne(saved.getId()), null);
    }

    @Test
    public void findAllTest() {
        Collection<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ENTITIES_IN_COLLECTION; i++) {
            profiles.add(EntityUtils.generateProfile());
        }
        profileRepository.save(profiles);

        Assert.assertEquals(NUMBER_OF_ENTITIES_IN_COLLECTION,
                profileService.findAll(new PageRequest(0, NUMBER_OF_ENTITIES_IN_COLLECTION)).getTotalElements());
    }
}
