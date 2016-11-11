package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import com.github.solairerove.woodstock.repository.GenericRepository;
import com.github.solairerove.woodstock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericServiceImpl<T extends BaseEntity, S> implements GenericService<T, S> {

    private final GenericRepository<T> repository;

    @Autowired
    public GenericServiceImpl(GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T create(Long id1, S s) {
        return null;
    }

    @Override
    public T get(Long id1, Long id2) {
        return null;
    }

    @Override
    public Iterable<T> getAll(Long id1) {
        return null;
    }
}
