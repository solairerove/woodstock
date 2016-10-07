package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import com.github.solairerove.woodstock.repository.ProfileRepository;
import com.github.solairerove.woodstock.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by krivitski-no on 9/14/16.
 */
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public String createProfile(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setCreatedDate(LocalDateTime.now());
        profileRepository.save(profile);
        return profile.getId();
    }

    @Override
    public Profile getProfile(String id) {
        return profileRepository.findOneProfileById(id);
    }

    @Override
    public String updateProfile(String id, ProfileDTO profileDTO) {
        if (profileRepository.exists(id)) {
            Profile profile = profileRepository.findOne(id);
            profile.setFirstName(profileDTO.getFirstName());
            profile.setLastName(profileDTO.getLastName());
            profile.setUpdatedDate(LocalDateTime.now());
            profileRepository.save(profile);
        }
        return id;
    }

    @Override
    public String deleteProfile(String id) {
        profileRepository.delete(id);
        return id;
    }

    @Override
    public List<Profile> deleteAll() {
        List<Profile> tickets = profileRepository.findAll();
        profileRepository.deleteAll();
        return tickets;
    }

    @Override
    public Page<Profile> findAll(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }
}
