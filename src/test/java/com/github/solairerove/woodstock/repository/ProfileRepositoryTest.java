package com.github.solairerove.woodstock.repository;

import com.github.solairerove.woodstock.Application;
import com.github.solairerove.woodstock.domain.Profile;
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
public class ProfileRepositoryTest {

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void findOneProfileByIdTest() {
        Profile saved = EntityUtils.generateProfile();
        profileRepository.save(saved);

        Assert.assertEquals(saved, profileRepository.findOneProfileById(saved.getId()));
    }
}
