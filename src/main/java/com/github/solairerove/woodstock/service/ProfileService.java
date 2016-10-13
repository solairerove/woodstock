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

    Profile create(ProfileDTO profileDTO);

    Profile get(String id);

    Page<Profile> findAll(Pageable pageable);

    Profile update(String id, ProfileDTO profileDTO);

    String delete(String id);

    List<Profile> deleteAll();
}
