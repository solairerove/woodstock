package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ReferenceDTO;

public interface ReferenceService {

    Reference create(String unitId, String moduleId, ReferenceDTO referenceDTO);

    Reference get(String unitId, String moduleId, String refId);

    Iterable<Reference> getAll(String unitId, String moduleId);

    Reference update(String unitId, String moduleId, String refId, ReferenceDTO referenceDTO);

    Reference delete(String unitId, String moduleId, String refId);
}
