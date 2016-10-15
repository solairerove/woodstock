package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by krivitski-no on 9/14/16.
 */
public interface ProfileService {

    Profile create(ProfileDTO profileDTO);

    Profile get(Long id);

    Page<Profile> findAll(Pageable pageable);

    Profile update(Long id, ProfileDTO profileDTO);

    Long delete(Long id);

    Iterable<Profile> deleteAll();
}
