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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ProfileServiceTest {

    @Autowired
    private ProfileRepository repository;

    @Autowired
    private ProfileService service;


    @Before
    public void setUp() {
        repository.deleteAll();
    }

    @After
    public void clear() {
        repository.deleteAll();
    }

    @Test
    public void createProfileTest() {
        ProfileDTO saved = generateProfileDTO();
        Long id = service.create(saved).getId();

        assertEquals(saved.getFirstName(), repository.findOne(id).getFirstName());
        assertEquals(saved.getLastName(), repository.findOne(id).getLastName());
    }

    @Test
    public void getProfileTest() {
        Profile saved = generateProfile();
        repository.save(saved);

        assertEquals(saved, service.get(saved.getId()));
    }

    @Test
    public void updateProfileTest() {
        Profile saved = generateProfile();
        repository.save(saved);
        Long id = saved.getId();

        ProfileDTO profileDTO = generateProfileDTO();
        String firstName = getRandomString();
        String lastName = getRandomString();
        profileDTO.setFirstName(firstName);
        profileDTO.setLastName(lastName);

        service.update(id, profileDTO);

        assertEquals(firstName, repository.findOne(id).getFirstName());
        assertEquals(lastName, repository.findOne(id).getLastName());
    }

    @Test
    public void deleteProfileTest() {
        Profile saved = generateProfile();
        repository.save(saved);

        service.delete(saved.getId());

        assertEquals(repository.findOne(saved.getId()), null);
    }

    @Test
    public void deleteAll() {
        repository.save(generateProfileCollection());

        service.deleteAll();

        assertEquals(0, repository.count());
    }

    @Test
    public void findAllTest() {
        repository.save(generateProfileCollection());
        int count = NUMBER_OF_ENTITIES_IN_COLLECTION;

        assertEquals(count, service.findAll(new PageRequest(0, count)).getNumberOfElements());
    }
}
