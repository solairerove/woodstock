package com.github.solairerove.woodstock.service.impl;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import com.github.solairerove.woodstock.repository.GenericRepository;
import com.github.solairerove.woodstock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl<T extends BaseEntity, REPO extends GenericRepository<T>>
        implements GenericService<T> {

    protected final REPO repository;

    @Autowired
    public GenericServiceImpl(REPO repository) {
        this.repository = repository;
    }

    @Override
    public T get(Long id1, Long id2) {
        return repository.getOneThatHasInNode(id1, id2);
    }

    @Override
    public Iterable<T> getAll(Long id1) {
        return repository.getAllThatHasInNode(id1);
    }
}
