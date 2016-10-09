package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Profile;
import com.github.solairerove.woodstock.dto.ProfileDTO;
import com.github.solairerove.woodstock.service.common.GenericService;

/**
 * Created by krivitski-no on 9/14/16.
 */
public interface ProfileService extends GenericService<Profile, String> {

    Profile update(String id, ProfileDTO profileDTO);
}
