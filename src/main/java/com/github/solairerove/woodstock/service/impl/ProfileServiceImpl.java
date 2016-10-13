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

    private final ProfileRepository repository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public Profile create(ProfileDTO profileDTO) {
        Profile profile = new Profile(profileDTO.getFirstName(), profileDTO.getLastName());
        profile.setCreatedDate(LocalDateTime.now().toString());
        return repository.save(profile);
    }

    @Override
    public Profile get(String id) {
        return repository.findOneProfileById(id);
    }

    @Override
    public Page<Profile> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Profile update(String id, ProfileDTO profileDTO) {
        Profile profile = repository.findOne(id);
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setUpdatedDate(LocalDateTime.now().toString());
        return repository.save(profile);
    }

    @Override
    public String delete(String id) {
        repository.delete(id);
        return id;
    }

    @Override
    public List<Profile> deleteAll() {
        List<Profile> profiles = repository.findAll();
        repository.deleteAll();
        return profiles;
    }
}
