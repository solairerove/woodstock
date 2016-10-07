package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by krivitski-no on 9/14/16.
 */
public interface ProfileService {
    String createProfile(ProfileDTO profileDTO);

    Profile getProfile(String id);

    String updateProfile(String id, ProfileDTO profileDTO);

    String deleteProfile(String id);

    List<Profile> deleteAll();

    Page<Profile> findAll(Pageable pageable);
}
