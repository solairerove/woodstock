package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import com.github.solairerove.woodstock.repository.ProfileRepository;
import com.github.solairerove.woodstock.service.ProfileService;
import com.github.solairerove.woodstock.service.common.AbstractGenericService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by krivitski-no on 9/14/16.
 */
@Service
public class ProfileServiceImpl extends AbstractGenericService<Profile, ProfileRepository, String>
        implements ProfileService {
    @Override
    public String create(ProfileDTO profileDTO) {
        Profile profile = new Profile(profileDTO.getFirstName(), profileDTO.getLastName());
        profile.setCreatedDate(LocalDateTime.now());
        repo.save(profile);
        return profile.getId();
    }

    @Override
    public String update(String id, ProfileDTO profileDTO) {
        Profile profile = repo.findOne(id);
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setUpdatedDate(LocalDateTime.now());
        repo.save(profile);
        return id;
    }
}
