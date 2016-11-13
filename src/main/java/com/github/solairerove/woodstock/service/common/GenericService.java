package com.github.solairerove.woodstock.service.common;

import com.github.solairerove.woodstock.domain.base.BaseEntity;

public interface GenericService<T extends BaseEntity> {

    T get(Long id1, Long id2);

    Iterable<T> getAll(Long id1);
}
