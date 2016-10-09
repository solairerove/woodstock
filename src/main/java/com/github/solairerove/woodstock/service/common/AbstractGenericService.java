package com.github.solairerove.woodstock.service.common;

import com.github.solairerove.woodstock.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by krivitski-no on 10/8/16.
 */
@Service
public abstract class AbstractGenericService<T extends BaseEntity, R extends MongoRepository<T, I>, I extends Serializable>
        implements GenericService<T, I> {

    protected final R repo;

    @Autowired
    public AbstractGenericService(R repo) {
        this.repo = repo;
    }

    @Override
    public T create(T t) {
        t.setCreatedDate(LocalDateTime.now());
        return repo.save(t);
    }

    @Override
    public T get(I i) {
        return repo.findOne(i);
    }

    @Override
    public I delete(I i) {
        repo.delete(i);
        return i;
    }

    @Override
    public List<T> deleteAll() {
        List<T> list = repo.findAll();
        repo.deleteAll();
        return list;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
