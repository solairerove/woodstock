package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.domain.Profile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.solairerove.woodstock.utils.EntityUtils.generateProfile;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileRepositoryTest {

    @Autowired
    private ProfileRepository repository;

    @Before
    public void setUp() {
        repository.deleteAll();
    }

    @After
    public void clear() {
        repository.deleteAll();
    }

    @Test
    public void getProfileTest() {
        Profile saved = generateProfile();
        repository.save(saved);

        assertEquals(saved, repository.getProfileFromId(saved.getId()));
    }
}
