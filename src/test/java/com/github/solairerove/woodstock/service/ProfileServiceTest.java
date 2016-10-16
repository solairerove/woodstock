package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import com.github.solairerove.woodstock.repository.ProfileRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.github.solairerove.woodstock.utils.EntityUtils.NUMBER_OF_ENTITIES_IN_COLLECTION;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateProfile;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateProfileCollection;
import static com.github.solairerove.woodstock.utils.EntityUtils.generateProfileDTO;
import static com.github.solairerove.woodstock.utils.EntityUtils.getRandomString;
import static org.junit.Assert.assertEquals;

/**
 * Created by krivitski-no on 9/28/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileRepository profileRepository;


    @Before
    public void setUp() {
        profileRepository.deleteAll();
    }

    @After
    public void clear() {
        profileRepository.deleteAll();
    }

    @Test
    public void createProfileTest() {
        ProfileDTO saved = generateProfileDTO();
        Long id = profileService.create(saved).getId();

        assertEquals(saved.getFirstName(), profileRepository.findOne(id).getFirstName());
        assertEquals(saved.getLastName(), profileRepository.findOne(id).getLastName());
    }

    @Test
    public void getProfileTest() {
        Profile saved = generateProfile();
        profileRepository.save(saved);

        assertEquals(saved, profileService.get(saved.getId()));
    }

    @Test
    public void updateProfileTest() {
        Profile saved = generateProfile();
        profileRepository.save(saved);
        Long id = saved.getId();

        ProfileDTO profileDTO = generateProfileDTO();
        String firstName = getRandomString();
        String lastName = getRandomString();
        profileDTO.setFirstName(firstName);
        profileDTO.setLastName(lastName);

        profileService.update(id, profileDTO);

        assertEquals(firstName, profileRepository.findOne(id).getFirstName());
        assertEquals(lastName, profileRepository.findOne(id).getLastName());
    }

    @Test
    public void deleteProfileTest() {
        Profile saved = generateProfile();
        profileRepository.save(saved);

        profileService.delete(saved.getId());

        assertEquals(profileRepository.findOne(saved.getId()), null);
    }

    @Test
    public void deleteAll() {
        profileRepository.save(generateProfileCollection());

        profileService.deleteAll();

        assertEquals(0, profileRepository.count());
    }

    @Test
    public void findAllTest() {
        profileRepository.save(generateProfileCollection());
        int count = NUMBER_OF_ENTITIES_IN_COLLECTION;

        assertEquals(count, profileService.findAll(new PageRequest(0, count)).getNumberOfElements());
    }
}
