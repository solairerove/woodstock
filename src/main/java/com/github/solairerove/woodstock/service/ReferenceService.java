package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.Reference;
import com.github.solairerove.woodstock.dto.ReferenceDTO;

public interface ReferenceService {

    Reference create(Long moduleId, ReferenceDTO referenceDTO);

    Reference get(Long moduleId, Long refId);

    Iterable<Reference> getAll(Long moduleId);
}
