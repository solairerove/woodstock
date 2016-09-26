package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.resource.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by krivitski-no on 9/14/16.
 */
@Service
@Transactional
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public String createProfile(Profile profile) {
        profileRepository.save(profile);
        return profile.getId();
    }

    public Profile getProfile(String id) {
        return profileRepository.findOneProfileById(id);
    }

    public Profile updateProfile(String id, Profile profile) {
        if (profileRepository.exists(id)) {
            profile.setId(id);
            createProfile(profile);
        }
        return profile;
    }

    public String deleteProfile(String id) {
        profileRepository.delete(id);
        return id;
    }

    public String deleteProfile(Profile profile) {
        profileRepository.delete(profile);
        return profile.getId();
    }

    public Page<Profile> findAll(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }
}
