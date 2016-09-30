package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.repository.ProfileRepository;
import com.github.solairerove.woodstock.utils.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
