package com.github.solairerove.woodstock.service;

import com.github.solairerove.woodstock.domain.base.BaseEntity;

public interface GenericService<T extends BaseEntity, S> {

    T create(Long id1, S s);

    T get(Long id1, Long id2);

    Iterable<T> getAll(Long id1);
}
