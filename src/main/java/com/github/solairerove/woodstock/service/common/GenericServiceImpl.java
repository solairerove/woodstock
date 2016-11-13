package com.github.solairerove.woodstock.service.common;

import com.github.solairerove.woodstock.domain.base.BaseEntity;
import com.github.solairerove.woodstock.repository.common.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class GenericServiceImpl<T extends BaseEntity> implements GenericService<T> {

    private final GenericRepository<T> repository;

    @Autowired
    public GenericServiceImpl(GenericRepository<T> repository) {
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
