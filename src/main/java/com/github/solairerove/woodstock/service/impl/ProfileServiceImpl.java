package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import com.github.solairerove.woodstock.repository.ProfileRepository;
import com.github.solairerove.woodstock.service.ProfileService;
import com.github.solairerove.woodstock.service.common.AbstractGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by krivitski-no on 9/14/16.
 */
@Service
public class ProfileServiceImpl extends AbstractGenericService<Profile, ProfileRepository, String>
        implements ProfileService {

    @Autowired
    public ProfileServiceImpl(ProfileRepository repo) {
        super(repo);
    }

    @Override
    public Profile update(String id, ProfileDTO profileDTO) {
        Profile profile = repo.findOne(id);
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setUpdatedDate(LocalDateTime.now().toString());
        return repo.save(profile);
    }
}
